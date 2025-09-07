<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Registration Form</title>
    <style>
        body {
            background-color: #b3e5fc;
            font-family: Arial, sans-serif;
        }
        table {
            background-color: #e1f5fe;
            padding: 20px;
            border-radius: 10px;
        }
        td {
            padding: 5px;
        }
        input[type=text], input[type=email], textarea, select {
            width: 250px;
        }
    </style>
</head>
<body>
<h2 align="center">Student Registration Form</h2>
<form action="registration-form" method="get">
    <table align="center">
        <tr>
            <td>First name</td>
            <td><input type="text" name="firstName" maxlength="30" required></td>
        </tr>
        <tr>
            <td>Last name</td>
            <td><input type="text" name="lastName" maxlength="30" required></td>
        </tr>
        <tr>
            <td>Date of Birth</td>
            <td>
                <select name="day">
                    <% for(int i=1;i<=31;i++){ %>
                    <option><%= i %></option>
                    <% } %>
                </select>
                <select name="month">
                    <% for(int i=1;i<=12;i++){ %>
                    <option><%= i %></option>
                    <% } %>
                </select>
                <select name="year">
                    <% for(int i=1980;i<=2024;i++){ %>
                    <option><%= i %></option>
                    <% } %>
                </select>
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="email" required></td>
        </tr>
        <tr>
            <td>Mobile number</td>
            <td><input type="text" name="mobileNumber" maxlength="10" required></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>
                <input type="radio" name="gender" value="Male">Male
                <input type="radio" name="gender" value="Female">Female
            </td>
        </tr>
        <tr>
            <td>Address</td>
            <td><textarea name="address" rows="4" cols="30"></textarea></td>
        </tr>
        <tr>
            <td>City</td>
            <td><input type="text" name="cityCode" maxlength="30"></td>
        </tr>
        <tr>
            <td>Pin code</td>
            <td><input type="text" name="pinCode" maxlength="6"></td>
        </tr>
        <tr>
            <td>State</td>
            <td><input type="text" name="state" maxlength="30"></td>
        </tr>
        <tr>
            <td>Country</td>
            <td><input type="text" name="country" value="India"></td>
        </tr>
        <tr>
            <td>Hobbies</td>
            <td>
                <input type="checkbox" name="hobbies" value="Drawing">Drawing
                <input type="checkbox" name="hobbies" value="Singing">Singing
                <input type="checkbox" name="hobbies" value="Dancing">Dancing
                <input type="checkbox" name="hobbies" value="Sketching">Sketching
                <input type="checkbox" name="hobbies" value="Others">Others
                <input type="text" name="hobbies">
            </td>
        </tr>
        <tr>
            <td>Qualification</td>
            <td>
                <table border="1" cellpadding="3">
                    <tr>
                        <th>Sl.No.</th>
                        <th>Examination</th>
                        <th>Board</th>
                        <th>Percentage</th>
                        <th>Year of Passing</th>
                    </tr>
                    <tr>
                        <td>1</td><td>Class X</td>
                        <td><input type="text" name="classXBoard"></td>
                        <td><input type="text" name="classXPercentage"></td>
                        <td><input type="text" name="classXYear"></td>
                    </tr>
                    <tr>
                        <td>2</td><td>Class XII</td>
                        <td><input type="text" name="classXIIBoard"></td>
                        <td><input type="text" name="classXIIPercentage"></td>
                        <td><input type="text" name="classXIIYear"></td>
                    </tr>
                    <tr>
                        <td>3</td><td>Graduation</td>
                        <td><input type="text" name="gradBoard"></td>
                        <td><input type="text" name="gradPercentage"></td>
                        <td><input type="text" name="gradYear"></td>
                    </tr>
                    <tr>
                        <td>4</td><td>Masters</td>
                        <td><input type="text" name="mastersBoard"></td>
                        <td><input type="text" name="mastersPercentage"></td>
                        <td><input type="text" name="mastersYear"></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>Course applies for</td>
            <td>
                <input type="radio" name="courses" value="BCA">BCA
                <input type="radio" name="courses" value="B.Com">B.Com
                <input type="radio" name="courses" value="B.Sc">B.Sc
                <input type="radio" name="courses" value="B.A">B.A
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Submit">
                <input type="reset" value="Reset">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
