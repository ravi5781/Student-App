<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pentagon Space - Application Form</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(to right, #f0f4ff, #ffe5ec);
        margin: 0;
        padding: 0;
    }

    h2, h3 {
        margin: 10px 0;
        text-align: center;
    }

    form {
        background-color: #fff;
        max-width: 420px;
        margin: 30px auto;
        padding: 25px;
        border-radius: 12px;
        box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
    }

    label {
        font-weight: 600;
        color: #2c3e50;
        display: block;
        margin-bottom: 5px;
        text-align: left;
        padding-left: 5%;
    }

    input[type="text"],
    input[type="password"] {
        width: 90%;
        padding: 10px;
        margin: 5px 0 15px 0;
        border: 1px solid #ccc;
        border-radius: 8px;
        box-sizing: border-box;
        transition: border 0.3s, box-shadow 0.3s;
    }

    input[type="text"]:focus,
    input[type="password"]:focus {
        border-color: #007bff;
        box-shadow: 0 0 6px rgba(0, 123, 255, 0.3);
        outline: none;
    }

    input[type="submit"] {
        width: 95%;
        padding: 12px;
        border-radius: 8px;
        background-color: #007bff;
        color: white;
        border: none;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.2s;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
        transform: scale(1.02);
    }

    span {
        font-size: 14px;
        color: #555;
    }

    a {
        color: #007bff;
        text-decoration: none;
        font-weight: bold;
    }

    a:hover {
        text-decoration: underline;
    }

    .error {
        color: #e74c3c;
        font-weight: bold;
        text-align: center;
        margin-bottom: 15px;
    }

    .success {
        color: #28a745;
        font-weight: bold;
        text-align: center;
        margin-bottom: 15px;
    }
</style>
</head>
<body>

	<h2 style="text-align: center; color: #002366;">Pentagon Space</h2>
	<h3 style="text-align: center; color: #4169E1;">Application form</h3>

	<form action="signup" method="post" style="text-align: center;">
		<%
		String error = (String) request.getAttribute("error");
		%>
		<%
		if (error != null) {
		%>
		<h3 class="error" style="text-align: center;"><%=error%></h3>
		<%
		}
		%>
		<label>Enter your Name:</label><br> <input type="text"
			name="name"><br>
		<br> <label>Enter the Phone number:</label><br> <input
			type="text" name="phone"><br>
		<br> <label>Enter the Mail ID:</label><br> <input
			type="text" name="mail"><br>
		<br> <label>Enter the Branch:</label><br> <input type="text"
			name="branch"><br>
		<br> <label>Enter the Location:</label><br> <input
			type="text" name="location"><br>
		<br> <label>Enter the password:</label><br> <input
			type="password" name="password"><br>
		<br> <label>Confirm the password:</label><br> <input
			type="password" name="confirmPassword"><br>
		<br> <input type="submit" value="create account"
			style="background-color: #007bff; color: white; padding: 8px 16px; border: none; cursor: pointer;"><br>
		<br> <span>already have a account? <a href="login.jsp">login</a></span>
	</form>

</body>
</html>
