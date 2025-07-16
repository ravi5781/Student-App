<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pentagon Space - Reset Password</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #eef2f3, #dbe9f4);
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
            color: #002366;
            margin-top: 30px;
        }

        h3 {
            text-align: center;
            color: #1E90FF;
        }

        form {
            background-color: #fff;
            max-width: 400px;
            margin: 30px auto;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
        }

        label {
            font-weight: bold;
            color: #333;
            display: block;
            text-align: left;
            margin-left: 5%;
        }

        input[type="text"],
        input[type="password"] {
            width: 90%;
            padding: 10px;
            margin: 8px 0 16px 0;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
            transition: border 0.3s, box-shadow 0.3s;
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: #007bff;
            box-shadow: 0 0 6px rgba(0, 123, 255, 0.2);
            outline: none;
        }

        input[type="submit"],
        button {
            padding: 10px 20px;
            border: none;
            border-radius: 6px;
            font-weight: bold;
            cursor: pointer;
            font-size: 15px;
            transition: all 0.3s ease;
        }

        input[type="submit"] {
            background-color: green;
            color: white;
            margin-right: 10px;
        }

        input[type="submit"]:hover {
            background-color: #028a0f;
        }

        button {
            background-color: #007bff;
            color: white;
        }

        button:hover {
            background-color: #0056b3;
        }

        .error {
            color: #e74c3c;
            text-align: center;
            font-weight: bold;
            margin-bottom: 15px;
        }

        .success {
            color: #28a745;
            text-align: center;
            font-weight: bold;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

    <h2>STUDENT MANAGEMENT SYSTEM</h2>
    <h3>
        <a href="#" style="color: #1E90FF; text-decoration: none;">Reset your password here</a>
    </h3>
    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
    <h3 class="error"><%= error %></h3>
    <% } %>

    <form action="ResetPassword" method="post" style="text-align: center;">
        <label>Enter the Phone number:</label><br>
        <input type="text" name="phone"><br><br>

        <label>Enter the Mail ID:</label><br>
        <input type="text" name="mail"><br><br>

        <label>Enter the password:</label><br>
        <input type="password" name="password"><br><br>

        <label>Confirm the password:</label><br>
        <input type="password" name="confirm"><br><br>

        <input type="submit" value="Reset Password">
        &nbsp;&nbsp;
        <a href="login.jsp">
            <button type="button">Back</button>
        </a>
    </form>

</body>
</html>
