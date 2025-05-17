<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Management</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 5px;
        }
        .action-links {
            display: inline;
        }
        .form-container {
            margin-bottom: 20px;
        }
        input[type="text"], input[type="number"] {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <h2>Customer List</h2>

    <!-- Add Customer Form -->
    <div class="form-container">
        <h3>Add New Customer</h3>
        <form action="/customers" method="post">
            <label>Name: </label>
            <input type="text" name="name" required/>
            <label>Age: </label>
            <input type="number" name="age" required/>
            <button type="submit">Add</button>
        </form>
    </div>

    <!-- Customer List -->
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.id}</td>
                    <td>
                        <form action="/customers/${customer.id}" method="post" style="display:inline;">
                            <input type="hidden" name="_method" value="PUT"/>
                            <input type="text" name="name" value="${customer.name}" required/>
                    </td>
                    <td>
                            <input type="number" name="age" value="${customer.age}" required/>
                            <button type="submit">Update</button>
                        </form>
                    </td>
                    <td class="action-links">
                        <form action="/customers/${customer.id}" method="post" style="display:inline;">
                            <input type="hidden" name="_method" value="DELETE"/>
                            <button type="submit" onclick="return confirm('Are you sure you want to delete this customer?')">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>