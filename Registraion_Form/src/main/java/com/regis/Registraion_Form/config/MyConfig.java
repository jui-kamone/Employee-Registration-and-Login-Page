package com.regis.Registraion_Form.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;


@EnableWebSecurity
@Configuration
public class MyConfig  {

    @Bean
    public UserDetailsService getUserDetailsService() {
        return new com.regis.Registraion_Form.config.CustomUserService();
    }
    @Bean
    public BCryptPasswordEncoder getPassword() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoProvider() {
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService((getUserDetailsService()));
        dao.setPasswordEncoder(getPassword());
        return dao;

    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoProvider());
    }

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/user/home").authenticated()
                    .requestMatchers("/user").hasRole("USER")
                    .anyRequest().permitAll()
            )
            .exceptionHandling(exceptions -> exceptions
                    .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")) // Redirect to login page if not authenticated
            )
            .formLogin(form -> form
                    .loginPage("/login")
                    .loginProcessingUrl("/dologin")
                    .usernameParameter("email")// Specify custom login page URL
                    .passwordParameter("password")
                    .defaultSuccessUrl("/user/home", true)
                    .permitAll() // Allow everyone to access the login page
            )
            .logout(logout -> logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login")  // Redirect to login page after logout
                    .permitAll()
            )
            .csrf(csrf -> csrf.disable()); // Disable CSRF for simplicity (consider enabling it in production)

    return http.build();

}

}
