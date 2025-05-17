# 💼 Customer Management System (Spring Boot + JSP)

A **simple web application** to manage customer records using **Spring Boot**, **JSP**, and **PostgreSQL**. It provides complete CRUD (Create, Read, Update, Delete) operations with a clean server-side rendered UI and REST-style endpoints.

---

## 🌟 Features

* 🏠 **Home Page**: Welcome interface linking to the customer management portal.
* 👥 **Customer Management**:

    * List all customers
    * Add new customers
    * Update customer details
    * Delete customers
* 💻 **Technologies Used**:

    * Spring Boot
    * JSP (Java Server Pages)
    * Hibernate (JPA)
    * PostgreSQL
* 📦 RESTful-style endpoints (PUT & DELETE simulated via form POST)
* 🧹 Server-side rendered UI using JSP

---

## ⚙️ Prerequisites

Ensure the following tools are installed:

* ☕ Java 17 or later
* 🐘 Maven
* 🐘 PostgreSQL v9.6 or higher
* 🧪 Postman or `curl` (optional, for API testing)

---

## 🛠️ Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone <repository-url>
cd customer-management-system
```

### 2️⃣ Configure PostgreSQL

Ensure PostgreSQL service is running.

Create a database:

```sql
CREATE DATABASE Employee;
```

Update credentials in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/Employee
spring.datasource.username=postgres
spring.datasource.password=root
```

🔐 Replace username/password as per your local setup.

### 3️⃣ Build the Project

```bash
mvn clean install
```

### 4️⃣ Run the Application

```bash
mvn spring-boot:run
```

Access the app at: [http://localhost:8080/](http://localhost:8080/)

---

## 🚀 Usage

### 🔗 Home Page

Visit: [http://localhost:8080/](http://localhost:8080/)

Message:

> "Welcome to the Customer Management System! Please use /customers to explore customer management features."

Click the `/customers` link or go directly to [http://localhost:8080/customers](http://localhost:8080/customers)

### 🧑‍💼 Customer Management Features

* View all customers
* Add a customer using the form
* Edit customer records inline
* Delete customers via the delete button

### ↻ REST Endpoints

| Method | Endpoint        | Description                        |
| ------ | --------------- | ---------------------------------- |
| GET    | /               | Welcome page                       |
| GET    | /customers      | List all customers                 |
| POST   | /customers      | Create a new customer              |
| POST   | /customers/{id} | Simulated PUT/DELETE via `_method` |
| PUT    | /customers/{id} | Update customer (simulated)        |
| DELETE | /customers/{id} | Delete customer (simulated)        |

📅 PUT & DELETE operations are simulated via POST using `_method` hidden field (since HTML forms don't support them natively).

---

## 🤮 Testing

### ✅ Using Browser

* Visit: `http://localhost:8080/`
* Navigate to `/customers` to manage via UI

### ⚒️ Using curl

#### List Customers

```bash
curl -v http://localhost:8080/customers
```

#### Create Customer

```bash
curl -v -X POST http://localhost:8080/customers \
     -d "name=TestUser" -d "age=25"
```

#### Update Customer (Replace `{id}`)

```bash
curl -v -X POST http://localhost:8080/customers/{id} \
     -d "_method=PUT" -d "name=UpdatedUser" -d "age=30"
```

#### Delete Customer (Replace `{id}`)

```bash
curl -v -X POST http://localhost:8080/customers/{id} \
     -d "_method=DELETE"
```

### 🧪 Using Postman

* **List**: `GET http://localhost:8080/customers`
* **Create**: `POST http://localhost:8080/customers`

    * Body (x-www-form-urlencoded): `name=TestUser`, `age=25`
* **Update**: `POST http://localhost:8080/customers/{id}`

    * Body: `_method=PUT`, `name=UpdatedUser`, `age=30`
* **Delete**: `POST http://localhost:8080/customers/{id}`

    * Body: `_method=DELETE`

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/example/
│   │   ├── controller/         # Controllers (Customer, Home)
│   │   ├── entity/             # JPA Entity: Customer
│   │   ├── repository/         # CustomerRepository (JPA)
│   │   └── service/            # Business logic
│   ├── resources/
│   │   ├── application.properties
│   │   └── data.sql            # Sample seed data
│   └── webapp/WEB-INF/views/
│       ├── home.jsp
│       └── customers.jsp
```

📅 Uses `HiddenHttpMethodFilter` to allow form-based PUT & DELETE simulation.

---

## 🚧 Future Improvements

* Replace JSP with React or Angular for modern UI
* Add authentication and role-based access control
* Add frontend validation and better error feedback

---

## 📜 License

Licensed under the [MIT License](https://opensource.org/licenses/MIT)
