<%@ page language="java" contentType="text/html; UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee List</title>
    <style>
        body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif;
            background-color: #f4f7f6;
            color: #333;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 900px;
            margin: 20px auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
        }

        h1 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 25px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f8f9fa;
            font-weight: bold;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        /* --- Kiểu cho các nút --- */
        .btn {
            display: inline-block;
            padding: 8px 15px;
            font-size: 14px;
            font-weight: bold;
            text-align: center;
            border-radius: 5px;
            text-decoration: none;
            cursor: pointer;
            transition: all 0.3s ease;
            color: #fff;
            border: none;
        }

        .btn-primary {
            background-color: #007bff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }

        .add-button {
            margin-bottom: 20px;
        }

        .btn-action {
            padding: 5px 10px;
            font-size: 12px;
            margin-right: 5px;
        }

        .btn-update {
            background-color: #28a745;
        }
        .btn-update:hover {
            background-color: #218838;
        }

        .btn-delete {
            background-color: #dc3545;
        }
        .btn-delete:hover {
            background-color: #c82333;
        }

        /* --- Kiểu cho Form (sẽ dùng ở trang register) --- */
        .form-table { width: 100%; }
        .form-table td {
            padding: 8px 0;
            border: none;
        }
        .form-table td:first-child {
            font-weight: bold;
            width: 120px;
        }

        input[type="text"] {
            width: calc(100% - 22px); /* 100% - padding - border */
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            margin-top: 15px;
            font-size: 16px;
        }

        /* --- Kiểu cho lỗi --- */
        .error {
            color: #dc3545;
            font-size: 12px;
            font-style: italic;
            margin-top: 4px;
            display: block;
        }

        .error-message {
            color: #721c24;
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
            padding: 15px;
            border-radius: 5px;
            text-align: center;
            font-size: 1.1em;
        }

    </style>
</head>
<body>

<div class="container">
    <h1>Employee List</h1>
    <a href="${pageContext.request.contextPath}/show-form" class="btn btn-primary add-button">+ Add Employee</a>
    <table>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Action</th>
        </tr>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/show-form-update?employeId=${employee.id}" class="btn-action btn-update">Update</a>
                    |
                    <a href="#" class="btn-action btn-delete">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>