<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="in.bg.studentapp.dto.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>STUDENT MANAGEMENT SYSTEM - Reset Password</title>
     <style>
        .success{
            color: green;
        }
        .error{
            color: red;
        }
    </style>
</head>
<body>

    <h2 style="text-align: center; color: #002366;">STUDENT MANAGEMENT SYSTEM</h2>
    <h3 style="text-align: center;">
        <a href="#" style="color: #1E90FF; text-decoration: none;">Reset your password here</a>
    </h3>
    	 <% Student s = new Student(); %>
     <%String error=(String)request.getAttribute("error"); %>
    <%if(error!=null){ %>
    <h3 class="error" style="text-align: center;"><%=error %></h3>
    <%} %>

	
    <form action="ResetPassword" method="post" style="text-align: center;">
        <label>Enter the Phone number:</label><br>
        <input type="text" name="phone" value="<%=s.getPhone() %>"><br><br>

        <label>Enter the Mail ID:</label><br>
        <input type="text" name="mail" value="<%=s.getMail()%>"><br><br>

        <label>Enter the password:</label><br>
        <input type="password" name="password"><br><br>

        <label>Confirm the password:</label><br>
        <input type="password" name="confirm"><br><br>

        <input type="submit" value="Reset Password" 
               style="background-color: green; color: white; padding: 8px 16px; border: none; cursor: pointer;">
        &nbsp;&nbsp;
        <a href="login.jsp">
            <button type="button" 
                    style="background-color: #007bff; color: white; padding: 8px 16px; border: none; cursor: pointer;">
                Back
            </button>
        </a>
    </form>

</body>
</html>
    