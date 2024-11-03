package com.regis.Registraion_Form.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="Email")
    private String email;
    @Column(name="Name")
    private String fullname;
    @Column(name="Password")
    private String password;
    @Column(name="Address")
    private String address;
    @Column(name = "State")
    private String state;

    @Column(name = "City")
    private String city;
    @Column(name="Gender")
    private String gender;
    @Column(name="DOB")
    private LocalDate dateofbirth;
    private String role;

    @Override
    public String toString() {
        return "User{" +

                ", id=" + id +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                "address='" + address + '\'' +
                ", state='" + state + '\'' +  // Include state in toString
                ", city='" + city + '\'' +
                ", gender='" + gender + '\'' +
                ", dateofbirth=" + dateofbirth +
                ", role='" + role + '\'' +
                '}';
    }
}
