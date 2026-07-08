# Enterprise.Storage1

A scalable enterprise-grade file storage service built using **Spring
Boot**, **MinIO (S3 Compatible Object Storage)**, and **MySQL**. The
application provides secure file upload, download, metadata management,
and soft delete functionality through RESTful APIs.

## 🚀 Features

-   Upload files to MinIO Object Storage
-   Download files using unique identifiers
-   Store file metadata in MySQL
-   Soft delete support
-   RESTful API architecture
-   Global exception handling
-   DTO-based request and response models
-   Validation using Jakarta Validation
-   Layered architecture (Controller → Service → Repository)
-   Configuration through `application.yml`
-   UUID-based file identification
-   Production-ready project structure

------------------------------------------------------------------------

## 🛠️ Tech Stack

  Technology           Version
  -------------------- ---------
  Java                 21
  Spring Boot          3.x
  Spring Data JPA      Latest
  MySQL                8+
  MinIO                Latest
  Maven                Latest
  Lombok               Latest
  Jakarta Validation   Latest

------------------------------------------------------------------------

## 📂 Project Structure

``` text
src
├── main
│   ├── java
│   │   └── com.enterprise.storage
│   │       ├── controller
│   │       ├── service
│   │       ├── repository
│   │       ├── entity
│   │       ├── dto
│   │       ├── exception
│   │       ├── config
│   │       └── util
│   └── resources
│       ├── application.yml
│       └── schema.sql
```

## ⚙️ Prerequisites

-   Java 21
-   Maven 3.9+
-   MySQL Server
-   MinIO Server

## 📦 Configuration

### MySQL

``` yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/storage_db
    username: root
    password: your_password
```

### MinIO

``` yaml
app:
  storage:
    endpoint: http://localhost:9000
    access-key: YOUR_ACCESS_KEY
    secret-key: YOUR_SECRET_KEY
    bucket-name: enterprise-storage
```

## ▶️ Running the Application

``` bash
git clone https://github.com/siddharth200606/Enterprise.Storage1.git
cd Enterprise.Storage1
mvn clean install
mvn spring-boot:run
```

## 📌 REST APIs

-   `POST /api/files/upload`
-   `GET /api/files/{id}`
-   `GET /api/files/metadata/{id}`
-   `DELETE /api/files/{id}`
-   `GET /api/files`

## 🗄️ Database

Metadata stored in MySQL:

-   File ID
-   Original File Name
-   Object Name
-   Content Type
-   File Size
-   Upload Timestamp
-   Status
-   Soft Delete Flag

Actual file contents are stored in **MinIO**.

## 🔐 Storage Flow

``` text
Client
   │
   ▼
Spring Boot REST API
   │
   ├────────────► MinIO (Stores File)
   ▼
MySQL (Stores Metadata)
```

## 👨‍💻 Author

**Siddharth**

GitHub: https://github.com/siddharth200606

## 📄 License

This project is licensed under the MIT License.
