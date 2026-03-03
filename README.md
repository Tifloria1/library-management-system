# Library Management System (Spring Boot + Angular)

Full-stack library management application with JWT authentication and role-based access (ADMIN / USER).

## Features
- JWT Authentication (Login)
- Role-based UI:
  - **ADMIN**: Add / Edit / Delete books
  - **USER**: View books + Borrow / Return
- Books: List + Search + Pagination + Details
- REST API (Spring Boot) + Angular Standalone components

## Tech Stack
**Backend:** Java, Spring Boot, Spring Security, JWT, JPA/Hibernate  
**Frontend:** Angular (Standalone), HttpInterceptor, Route Guards  
**Database:** MySQL  

## Screenshots
![Login](screenshots/login.png)
![Admin](screenshots/admin-books.png)
![User](screenshots/user-books.png)


## Project Structure
Library_Management_app/ # Spring Boot backend
Library_Management_app_FrontEnd/ # Angular frontend

## Getting Started (Local)

### 1) Backend (Spring Boot)
1. Create a MySQL database (example): `library_db`
2. Update `application.properties` (DB username/password)
3. Run

cd Library_Management_app
mvn spring-boot:run

Backend runs on: http://localhost:8083

Backend runs on: http://localhost:8083

```bash
cd Library_Management_app_FrontEnd
npm install
ng serve
```

Frontend runs on: http://localhost:4200

API Endpoints (example)

POST /api/auth/login → returns { token }

GET /api/auth/me → returns current user { username, role }

GET /api/books → list books

POST /api/books/{id}/borrow

POST /api/books/{id}/return

Notes

Angular uses an HTTP Interceptor to attach Authorization: Bearer <token> to protected requests.

Interceptor skips /api/auth/login (no token needed).

Then:

```bash
git add README.md
git commit -m "Add project documentation"
git push

