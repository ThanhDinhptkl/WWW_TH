<%@ page language="java" contentType="text/html; UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Form</title>
    <style>
        body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif;
            background-color: #f4f7f6;
            color: #333;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 600px; /* Nhỏ hơn cho form */
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

        /* --- Kiểu cho Form (sẽ dùng ở trang register) --- */
        .form-table { width: 100%; }
        .form-table tr, .form-table td {
            padding: 8px 0;
            border: none;
            background-color: transparent !important;
        }
        .form-table td:first-child {
            font-weight: bold;
            width: 120px;
        }

        /* Áp dụng cho cả input thường và form:input */
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: calc(100% - 22px); /* 100% - padding - border */
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            transition: border-color 0.3s, box-shadow 0.3s;
        }

        input[type="text"]:focus,
        input[type="email"]:focus,
        input[type="password"]:focus {
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0,123,255,0.25);
            outline: none;
        }

        input[type="submit"].btn {
            width: 100%;
            margin-top: 15px;
            padding-top: 12px;
            padding-bottom: 12px;
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

    </style>
</head>
<body>

<div class="container">
    <h1>Employee Form</h1>

    <%--@elvariable id="employee" type="java"--%>
    <form:form action="${pageContext.request.contextPath}/save" method="post" modelAttribute="employee">
        <table class="form-table">
            <form:hidden path="id"/>
            <tr>
                <td>First Name:</td>
                <td>
                    <form:input path="firstName"/>
                    <form:errors path="firstName" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td>
                    <form:input path="lastName"/>
                    <form:errors path="lastName" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Save Changes" class="btn btn-primary"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>