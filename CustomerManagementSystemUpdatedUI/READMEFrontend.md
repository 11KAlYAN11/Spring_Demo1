# Customer Management System - Frontend

This directory contains the **React frontend** for the **Customer Management System**, a web application that allows users to manage customer data (CRUD operations) through a modern UI. The frontend is built with **React**, styled using **Tailwind CSS**, and communicates with a **Spring Boot** backend via REST APIs.

---

## 🛠️ Tech Stack

* **React** – JavaScript library for building user interfaces.
* **React Router** – For client-side routing (`/` for Home, `/customers` for Customer List).
* **Tailwind CSS** – Utility-first CSS framework for modern styling.
* **Axios** – For HTTP requests to backend APIs.
* **Node.js & npm** – For dependency management and running the dev server.

---

## 📁 Project Structure

```
frontend/
├── src/
│   ├── components/
│   │   ├── Home.js             # Home page component
│   │   └── CustomerList.js     # Customer CRUD operations
│   ├── App.js                  # Main app with routing
│   ├── index.js                # React entry point
│   └── index.css               # Global styles with Tailwind
├── public/
│   └── index.html              # HTML template
├── build/                      # Production build output
├── package.json                # Dependencies & scripts
├── tailwind.config.js          # Tailwind configuration
└── postcss.config.js           # PostCSS configuration
```

---

## ✅ Prerequisites

* Node.js (v16 or higher)
* Backend Spring Boot server running at `http://localhost:8080/` (refer to root `README.md`)

---

## 🚀 Setup Instructions

### 1. Navigate to Frontend Directory

```bash
cd frontend
```

### 2. Install Dependencies

```bash
npm install
```

Installs React, Tailwind CSS, Axios, React Router, etc.

### 3. Build the Frontend

The Spring Boot backend serves the app from the `frontend/build/` directory:

```bash
npm run build
```

Generates production-ready assets in the `build/` folder.

---

## ▶️ Running the Frontend

The frontend is **served by the Spring Boot backend**. You do **not** need to run a separate React development server.

### ✅ Ensure Backend Is Running

Use this command to start the Spring Boot app:

```bash
mvn spring-boot:run
```

Backend config (`application.properties`) must include:

```properties
spring.web.resources.static-locations=file:./frontend/build/
```

### 🌐 Access the App

Open your browser at:

```
http://localhost:8080/
```

* `/` – Welcome message & link to manage customers
* `/customers` – Add, edit, delete, and list customers

---

## ⚠️ Note on Refreshing

Refreshing pages like `/customers` may show raw JSON API responses due to React Router's client-side nature.

**Solution:** Use in-app links/buttons for navigation instead of browser refresh.

---

## 🧪 Development Mode

To develop the frontend separately (with hot reloading):

### 1. Start React Development Server

```bash
npm start
```

Runs the frontend at:

```
http://localhost:3000/
```

### 2. Update API URLs in `CustomerList.js`

Use full URLs:

```javascript
axios.get("http://localhost:8080/customers")
```

### 3. Enable CORS in Backend

Refer to backend docs to configure `CorsConfig.java`.

### 4. Build for Backend After Changes

```bash
npm run build
```

---

## ✨ Features

* **Home Page (`/`)**

    * Welcome message
    * Link to customer management

* **Customer Management (`/customers`)**

    * View customers in a table
    * Add customer (Name + Age)
    * Edit customer details
    * Delete customers

* **UI & Styling**

    * Responsive layout
    * Tailwind CSS for modern design

---

## 🐞 Known Issues

* Refreshing client-side routes (like `/customers`) directly may load backend JSON.
* Backend must be running, else the app will fail to fetch data.

---

## 🛣️ Next Steps

* Implement server-side routing fallback to `index.html` for all non-API routes.
* Add form validation (e.g., required fields, age must be positive).
* Enhance UX with loading spinners and error messages for failed API calls.

---

## 📄 License

This project is for **educational purposes only** and not licensed for production use.
