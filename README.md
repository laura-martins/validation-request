# ValidationRequest Project

## Overview
`ValidationRequest` is a project focused on request validation. It uses a hexagonal architecture to ensure a clear separation between application layers.

## Features
 - Create QR Code

 - Retrieve QR Code 

 - Update QR Code 

 - Delete QR Code

## Technologies Used
 - Kotlin
 - Spring Boot
 - Hibernate/JPA
 - H2 Database
 - Maven
 - JUnit

## Project Structure
```
src/
├── adapter/
├── configuration/
├── controller/
│   ├── handler/
│   ├── mapper/
│   ├── request/
│   └── response/
├── domain/
│   └── enums/
├── entity/
├── exception/
├── port/
├── usecase/
│   └── mapper/
```

### Explanation

- **adapter/**: Contains adapters for external services (Database, APIs, queues, cache, etc.).
- **configuration/**: Framework configurations (Spring, for example) and other general settings.
- **controller/**: Application entry point, where API requests are received.
    - **handler/**: Responsible for handling specific exceptions.
    - **mapper/**: Converts between domain objects and DTOs.
    - **request/**: Request models for the API.
    - **response/**: Response models for the API.
- **domain/**: Contains business rules and main domain objects.
    - **enums/**: Enumerations related to the domain.
- **entity/**: Represents entities persisted in the database.
- **exception/**: Contains domain-related exceptions.
- **port/**: Interfaces.
- **usecase/**: Use cases that contain business logic.
  - **mapper/**: Converts between domain objects and entities/DTOs.

This organized format helps developers and collaborators understand the structure and responsibility of each layer in the project.

## How to Run the Project
1. Install project dependencies using Maven: `mvn clean install`
2. Run the application: `mvn spring-boot:run`