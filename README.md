# 🎓 Student Management System

A powerful and secure **Student Management System** built using **Spring Boot**, **Hibernate/JPA**, and **MySQL**.  
This project demonstrates modern backend development concepts including authentication, layered architecture, REST APIs, password encryption, and database integration.

---

# 🚀 Features

✨ Student Registration  
✨ Student Login Authentication  
✨ Password Encryption using BCrypt  
✨ REST API Development  
✨ CRUD Operations  
✨ Layered Architecture Implementation  
✨ MySQL Database Integration  
✨ File Upload Support  
✨ JSON Response Handling  
✨ Exception Handling  
✨ Secure Password Storage  

---

# 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| ☕ Java | Core Programming Language |
| 🌱 Spring Boot | Backend Framework |
| 🗄️ MySQL | Database |
| 🔥 Hibernate / JPA | ORM Framework |
| 🔐 Spring Security | Authentication & Security |
| 📦 Maven | Dependency Management |
| 🧪 Postman | API Testing |

---

# 🏗️ Project Architecture

This project follows the **Layered Architecture Pattern**.

## 📌 Controller Layer
Handles incoming HTTP requests and sends responses to the client.

## 📌 Service Layer
Contains the business logic of the application.

## 📌 Repository Layer
Communicates with the database using JPA/Hibernate.

## 📌 Database Layer
Stores student information securely in MySQL.

---

# 🔄 Complete Flow

```text
Client Request
      ↓
Controller Layer
      ↓
Service Layer
      ↓
Repository Layer
      ↓
MySQL Database
      ↓
Response Returned to Client
```

---

# 🔐 Security Features

✅ Password Encryption using BCrypt  
✅ Password Hidden from API Responses  
✅ Secure Login Verification  
✅ Structured API Responses  

---

# 📂 Main Functionalities

## 👨‍🎓 Student Management
- Add Student
- Update Student
- Delete Student
- Fetch Student Details

## 🔑 Authentication
- Register New User
- Login Validation
- Password Encryption

## 📁 File Handling
- Upload Files
- Store File Paths

---

# 📡 API Testing

All APIs were tested using **Postman**.

Example APIs:

```http
POST /register
POST /login
GET /students
PUT /students/{id}
DELETE /students/{id}
```

---

# ⚙️ How To Run The Project

## 1️⃣ Clone Repository

```bash
git clone https://github.com/Ayan70036/Student_Management.git
```

---

## 2️⃣ Open Project

Open using:
- IntelliJ IDEA
- Eclipse
- VS Code

---

## 3️⃣ Configure Database

Create a MySQL database and update:

```properties
application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
spring.datasource.username=root
spring.datasource.password=yourpassword
```

---

## 4️⃣ Run Application

Run the Spring Boot application:

```bash
mvn spring-boot:run
```

---

# 📸 Future Improvements

🚀 JWT Authentication  
🚀 Role-Based Authorization  
🚀 React Frontend  
🚀 Cloud Deployment  
🚀 Swagger Documentation  
🚀 Docker Support  

---

# 🧠 Concepts Used

✔️ Dependency Injection  
✔️ REST APIs  
✔️ MVC Architecture  
✔️ Hibernate ORM  
✔️ Spring Security  
✔️ Exception Handling  
✔️ JSON Serialization  
✔️ Password Encryption  

---

# 👨‍💻 Author

## Ayan Malakar

Passionate about Backend Development, Spring Boot, and building scalable Java applications 🚀

---

# ⭐ Support

If you liked this project, consider giving it a ⭐ on GitHub!
