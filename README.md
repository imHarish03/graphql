
# GraphQL Employee Service

A Spring Boot + GraphQL application to manage Employees and Departments using MySQL, Spring Data JPA, and GraphQL APIs.

---

## 🚀 Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring for GraphQL
- Spring Data JPA
- MySQL
- Lombok
- Gradle
- Postman (for API testing)

---

## 📦 Project Structure

```
src
├── main
│   ├── java/io/lab/imHarish03
│   │   ├── controller
│   │   ├── service
│   │   ├── entity
│   │   ├── repository
│   │   └── GraphqlDemoApplication.java
│   └── resources
│       ├── graphql/schema.graphqls
│       └── application.properties
```

---

## ⚙️ Configuration

Update your `src/main/resources/application.properties` to match your local MySQL setup:

```properties
spring.application.name=graphql-demo

spring.datasource.url=jdbc:mysql://localhost:3306/employee_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

---

## 📂 Postman Collection

To test the GraphQL APIs using Postman:

1. Import the collection from:
   ```
   postman/employee-graphql.postman_collection.json
   ```
2. Set the request URL to:
   ```
   http://localhost:8080/graphql
   ```

---

## 🧪 Sample GraphQL Requests

### 📝 Create Employee

```graphql
mutation {
  createEmployee(name: "Hari", email: "hari@example.com", departmentId: 1) {
    id
    name
    email
    department {
      name
    }
  }
}
```

---

### ✏️ Update Employee

```graphql
mutation UpdateEmployee($input: EmployeeInput!) {
  updateEmployee(input: $input) {
    id
    name
    email
    department {
      id
      name
    }
  }
}
```

Payload:

```json
{
  "input": {
    "id": 1,
    "name": "Hariharan R",
    "email": "harish@lab.io",
    "departmentId": 2
  }
}
```

---

### 🔍 Get All Employees (Paginated)

```graphql
query {
  allEmployees(page: 0, size: 5) {
    id
    name
    email
    department {
      name
    }
  }
}
```

---

## 🗂️ GraphQL Schema

```graphql
type Department {
  id: ID
  name: String
}

type Employee {
  id: ID
  name: String
  email: String
  department: Department
}

type Query {
  allEmployees(page: Int = 0, size: Int = 10): [Employee]
  employeeById(id: ID): Employee
  employeesByDepartmentId(departmentId: ID!): [Employee]
}

type Mutation {
  createEmployee(name: String!, email: String!, departmentId: ID!): Employee
  updateEmployee(input: EmployeeInput!): Employee
}

input EmployeeInput {
  id: ID
  name: String
  email: String
  departmentId: ID
}
```

---

## ▶️ Running the Application

### Run from Gradle

```bash
./gradlew bootRun
```

### Build JAR

```bash
./gradlew build
```

Run the JAR:

```bash
java -jar build/libs/graphql-demo-0.0.1-SNAPSHOT.jar
```

---

## ✅ TODOs

- [ ] Add `deleteEmployee` mutation
- [ ] Add validation annotations (`@NotNull`, `@Email`, etc.)
- [ ] Add `createDepartment`, `getAllDepartments` endpoints
- [ ] Add unit tests and GraphQL integration tests
- [ ] Convert `EmployeeInput` to use composition (not inheritance)

---

## 👤 Author

**Hariharan R**  
GitHub: [@imHarish03](https://github.com/imHarish03)  
Email: harishhari302@gmail.com

---
