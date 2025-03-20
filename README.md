# Replica of SplitwiseApplication Application

## 🎭 About the Project
A simplified clone of the Splitwise application built using **Spring Boot**. This project aims to replicate the core functionality of Splitwise, allowing users to track, split, and manage expenses among friends or groups.

## 🚀 Features
- User registration and authentication
- Create and manage groups
- Add expenses and split them among group members
- Track balances (who owes whom)
- Basic expense settlement functionality
- RESTful API for interaction

## 🛠️ Tech Stack
- **Spring Boot**: Backend framework for building the application
- **Spring Data JPA**: For database interactions
- **mySQL Database**: In-memory database (can be swapped with PostgreSQL)
- **Spring Security**: For authentication and authorization
- **Maven**: Dependency management and build tool
- **Java**: Core programming language (version 17 recommended)

## 📌 Installation & Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/dharshan-kumar-ks/SplitwiseApplication.git
   cd SplitwiseApplication
   ```
2. Install dependencies:
   ```bash
   mvn clean install  # If using Spring Boot
   ```
3. Configure the database in `application.properties` (Spring Boot) 
4. Run the application:
   ```bash
   mvn spring-boot:run  # If using Spring Boot
   ```

## 📖 API Endpoints Documentation
Here are some key endpoints:
- POST /api/users/register - Register a new user
- POST /api/users/login - Authenticate a user
- GET /api/users/{id} - Get user details
- POST /api/groups - Create a new group
- POST /api/expenses - Add a new expense
- GET /api/expenses/{groupId} - List expenses in a group
- GET /api/balances/{groupId} - View balances in a group

Detailed API documentation is available via Swagger UI (`/swagger-ui` route when running the server)     (Not Implemented yet)

## 🤝 Contributing
We welcome contributions! Feel free to fork the repo and submit pull requests.

## 📝 License
This project is licensed under the MIT License.

## 📬 Contact
For any queries, feel free to reach out:
- Email: dharshankumar55@gmail.com
- GitHub Issues: [Open an issue](https://github.com/dharshan-kumar-ks/BookMyShowApplication/issues)
