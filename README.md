# 🔐 Spring Boot Login & Registration API
This project is a simple Login and Registration backend API built using Spring Boot, Spring Security, and JPA. It allows users to register with email and password and then login using the same credentials.

Passwords are securely stored using BCrypt password hashing.

## 🚀 Features
User Registration API
User Login API
Password encryption using BCrypt
Spring Security configuration
RESTful APIs
MySQL / JPA database integration
CORS configuration for frontend connection

## 🛠️ Technologies Used
Java
Spring Boot
Spring Security
Spring Data JPA
Hibernate
MySQL (or any JPA supported database)
Maven


## 📂 Project Structure
src/main/java/com/login/demo
│
├── config
│   └── SecurityConfig.java
│
├── controller
│   └── AuthController.java
│
├── DTO
│   ├── LoginRequest.java
│   └── RegisterRequest.java
│
├── entity
│   └── User.java
│
├── repository
│   └── UserRepository.java
│
├── service
│   └── AuthService.java
│
└── LoginandRegistrationApplication.java


## ⚙️ API Endpoints
1️⃣ Register User
Endpoint

POST /auth/register
Request Body

{
  "email": "user@example.com",
  "password": "12345"
}
Response
User Registered Successfully!


2️⃣ Login User
Endpoint

POST /auth/login
Request Body

{
  "email": "user@example.com",
  "password": "12345"
}
Response

Login Successful!
If password is incorrect:

Invalid Password!

## 🔐 Security
This project uses:

BCryptPasswordEncoder to hash passwords
Spring Security Filter Chain
CORS configuration for frontend communication

## ▶️ How to Run the Project
1️⃣ Clone the repository
git clone https://github.com/your-username/your-repository-name.git

2️⃣ Open project in IDE
IntelliJ IDEA
Spring Tool Suite (STS)
Eclipse

3️⃣ Configure Database
Update application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/sakila
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update

4️⃣ Run the Application
Run:

LoginandRegistrationApplication.java
Spring Boot will start on:

http://localhost:8080
## 📌 Future Improvements
JWT Authentication
Role based authorization
Email verification
Password reset feature
Refresh tokens
