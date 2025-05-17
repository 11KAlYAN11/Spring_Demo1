<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Form</title>
</head>
<body>
    <h2>${customer.id == 0 ? 'Add Customer' : 'Edit Customer'}</h2>
    <c:set var="formAction" value="${customer.id == 0 ? '/employee-management/customers/add' : '/employee-management/customers/update/'.concat(customer.id)}" />
    <form action="${formAction}" method="post">
        <label>Name: </label>
        <input type="text" name="name" value="${customer.name}" required/><br><br>
        <label>Age: </label>
        <input type="number" name="age" value="${customer.age}" required/><br><br>
        <button type="submit">${customer.id == 0 ? 'Add' : 'Update'}</button>
        <a href="/employee-management/customers">Cancel</a>
    </form>
</body>
</html>