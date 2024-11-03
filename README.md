
# Employee Registration Form

This is a Spring Boot application designed to manage employee registration and display user details in a user-friendly web interface. The application includes secure login and registration functionality, user role-based access, and customizable UI.

## Table of Contents
- [Features](###features)
- [Configuration](###configuration)
- [Usage](###usage)
- [Example Usage](###example-usage)



### Features
User Registration: Users can register with unique credentials.
Login/Logout System: Secure login and logout features with encrypted passwords.
Role-based Access: Certain pages (like /user/home) are accessible only after login.
User-Friendly Interface: Clean UI using Thymeleaf templates, with a Persian blue theme.
Database Support: Stores user data in MySQL.

### Configuration
To ensure smooth login and registration:

### User Roles:
Users with the role USER can access /user/home. Ensure users are assigned this role during registration.
Password Encoding: The application uses BCryptPasswordEncoder for secure password encryption.

### Usage
#### 1)Home Page:
Displays all registered users (restricted to authenticated users).
#### 2)Registration Page:
New users can register themselves.
#### 3)Login Page: 
Users can log in with their registered email and password.
#### 4)Logout:
Accessible from the user dashboard for a secure logout.

### Example Usage

#### Register a New User:

![1  Registration Page](https://github.com/user-attachments/assets/c5056b14-2a88-45ed-a913-0c9d9f71eaa1)

#### Login: Log in using registered credentials.

![2  Log In Page](https://github.com/user-attachments/assets/0fa5bfc0-469e-430e-8f40-15940923b85e)

#### View User Home Page: After login, see all registered users in the system. 

![3  Welcome Page,( List Of All Users Registered)](https://github.com/user-attachments/assets/c6964998-8594-4484-a279-ebc32483d702)


#### Database :

![4  Database Page(List Of All Users Registered)](https://github.com/user-attachments/assets/470e7ed8-559d-4ae4-83b6-d4de1fed764a)

