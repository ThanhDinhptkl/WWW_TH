<%@ page language="java" contentType="text/html; UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>
    <style>
        body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif;
            background-color: #f4f7f6;
            color: #333;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 600px;
            margin: 40px auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
            text-align: center;
        }

        h1 {
            text-align: center;
            color: #dc3545; /* Màu đỏ cho lỗi */
            margin-bottom: 25px;
        }

        .error-message {
            color: #721c24;
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
            padding: 20px;
            border-radius: 5px;
            text-align: center;
            font-size: 1.1em;
            font-weight: 500;
        }

        a.back-link {
            display: inline-block;
            margin-top: 25px;
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
        }

        a.back-link:hover {
            text-decoration: underline;
        }

    </style>
</head>
<body>

<div class="container">
    <h1>An Error Occurred</h1>
    <div class="error-message">
        ${errorMessage}
    </div>

    <a href="javascript:history.back()" class="back-link">&laquo; Go Back</a>
</div>

</body>
</html>