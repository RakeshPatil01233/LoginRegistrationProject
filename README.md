# 🔐 Spring Boot Login & Registration API (JWT Secured)

This project is a backend authentication system built using **Spring Boot, Spring Security, JPA, and JWT**.  
It allows users to register, login, and access protected APIs using token-based authentication.

Passwords are securely stored using **BCrypt hashing**, and APIs are secured using **JWT (JSON Web Token)**.

---

## 🚀 Features

- User Registration API
- User Login API (returns JWT token)
- Password encryption using BCrypt
- JWT-based Authentication
- Protected REST APIs
- Spring Security integration
- MySQL / JPA database integration
- CORS configuration for frontend

---

## 🛠️ Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- JWT (io.jsonwebtoken)
- Maven

---

## 📂 Project Structure

```
src/main/java/com/example/FirstApi
│
├── config
│   ├── SecurityConfig.java
│   ├── JwtUtil.java
│   └── JwtFilter.java
│
├── controller
│   └── AuthController.java
│
├── dto
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
```

## ⚙️ API Endpoints

### 1️⃣ Register User

**POST** `/auth/register`

**Request Body:**
```json
{
  "email": "user@example.com",
  "password": "12345"
}
```
**Response:**
```
User Registered Successfully!
```
---

### 2️⃣ Login User

**POST** `/auth/login`

**Request Body:**
```json
{
  "email": "user@example.com",
  "password": "12345"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

---

### 3️⃣ Protected API

**GET** `/auth/api/test`

**Headers:**
```
Authorization: Bearer <JWT_TOKEN>
```

**Response:**
```
You are authenticated!
```

---

## 🔐 Security

This project uses:

- BCryptPasswordEncoder → secure password hashing  
- JWT Token → stateless authentication  
- JwtFilter → validates token on every request  
- Spring Security Filter Chain → protects APIs  

---

## ▶️ How to Run the Project

### 1️⃣ Clone the repository

```bash
git clone https://github.com/your-username/your-repository-name.git
```

---

### 2️⃣ Open in IDE

- IntelliJ IDEA  
- Eclipse  
- Spring Tool Suite (STS)  

---

### 3️⃣ Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sakila
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```

---

### 4️⃣ Run the Application

Run:

```
LoginandRegistrationApplication.java
```

Server starts at:

```
http://localhost:8080
```

---

## 📌 Future Improvements

- Role-based authorization (USER / ADMIN)
- Refresh token implementation
- Email verification
- Password reset feature
- Frontend integration (React)

---

## 💡 Key Learning

- Implemented JWT Authentication in Spring Boot  
- Integrated Spring Security with custom filter  
- Built stateless authentication system  
- Secured REST APIs using token-based approach 

