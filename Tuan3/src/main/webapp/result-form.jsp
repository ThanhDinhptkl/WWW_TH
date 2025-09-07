<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="iuh.fit.se.tuan3.Bai1.entity.Student" %>

<%
    Student student = (Student) request.getAttribute("student");
%>
<html>
<head>
    <title>Registration Result</title>
    <style>
        body {
            background-color: #f1f8e9;
            font-family: Arial, sans-serif;
        }
        table {
            background-color: #ffffff;
            border-collapse: collapse;
            margin: 20px auto;
            padding: 20px;
            width: 70%;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 10px;
        }
        td, th {
            padding: 8px 12px;
            border: 1px solid #ccc;
        }
        h2 {
            text-align: center;
        }
    </style>
</head>
<body>
<h2>Student Registration Details</h2>

<% if (student != null) { %>
<table>
    <tr><th>First Name</th><td><%= student.getFirstName() %></td></tr>
    <tr><th>Last Name</th><td><%= student.getLastName() %></td></tr>
    <tr><th>Date of Birth</th><td><%= student.getDateOfBirth() %></td></tr>
    <tr><th>Email</th><td><%= student.getEmail() %></td></tr>
    <tr><th>Mobile Number</th><td><%= student.getMobileNumber() %></td></tr>
    <tr><th>Gender</th><td><%= student.getGender() %></td></tr>
    <tr><th>Address</th><td><%= student.getAddress() %></td></tr>
    <tr><th>City</th><td><%= student.getCityCode() %></td></tr>
    <tr><th>Pin Code</th><td><%= student.getPinCode() %></td></tr>
    <tr><th>State</th><td><%= student.getState() %></td></tr>
    <tr><th>Country</th><td><%= student.getCountry() %></td></tr>
    <tr><th>Hobbies</th><td>
        <% if(student.getHobbies() != null){
            for(String h : student.getHobbies()){ %>
        <%= h %><br/>
        <%   }
        } else { %> None <% } %>
    </td></tr>
    <tr><th>Qualifications</th><td><%= student.getQualifications() %></td></tr>
</table>
<% } else { %>
<p style="text-align:center; color:red;">No student data found!</p>
<% } %>

</body>
</html>
