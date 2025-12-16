# Spring Boot E-Commerce Checkout System

A full-stack e-commerce checkout backend built with **Java, Spring Boot, and MySQL**, designed to process customer orders, persist relational data, and integrate with an Angular front-end. This project demonstrates production-style backend patterns including REST APIs, DTO-based request handling, transactional workflows, and database persistence.

---

## 🚀 Features

- RESTful checkout API to place customer orders
- End-to-end order processing (Customer → Cart → Cart Items)
- Transactional service layer with cascade persistence
- Unique order tracking number generation
- Integration with an Angular front-end checkout flow
- MySQL database persistence verified via Workbench

---

## 🛠️ Tech Stack

**Backend**
- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- RESTful APIs

**Database**
- MySQL
- MySQL Workbench

**Frontend Integration**
- Angular (unmodified provided front-end)

**Tools**
- Git & GitHub
- IntelliJ IDEA
- Maven

---

## 🧩 Architecture Overview

- **Controller Layer**  
  Exposes REST endpoints for checkout operations.

- **Service Layer**  
  Handles business logic and transactional order placement.

- **DTO Layer**  
  Decouples API requests from persistence models.

- **Entity Layer**  
  Models relational data using JPA annotations.

- **Repository Layer**  
  Manages database operations via Spring Data JPA.

---

## 📦 Checkout Flow

1. Angular front-end submits a purchase request
2. Checkout controller receives the request
3. Service layer processes and validates the order
4. Order tracking number is generated
5. Customer, cart, and cart items are persisted atomically
6. Confirmation response is returned to the client

---

## 📸 Validation & Testing

- Network requests verified via browser DevTools (HTTP 200 OK)
- Database records validated using MySQL Workbench
- End-to-end checkout confirmed with persisted data

---

## 🎓 What This Project Demonstrates

- Full-stack application integration
- Clean backend architecture and layering
- Transaction management and relational data modeling
- REST API design and DTO usage
- Real-world debugging and persistence verification

---

## 📌 Notes

This project was developed as part of an academic backend programming course and reflects industry-aligned best practices for entry-level software engineering roles.
