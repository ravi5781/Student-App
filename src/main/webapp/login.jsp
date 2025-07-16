<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pentagon Space - Login</title>
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

    <h2 style="text-align: center; color: #002366;">Pentagon Space</h2>
    <h3 style="text-align: center;">
        <a href="#" style="color: #1E90FF; text-decoration: none;">Login</a>
    </h3>
    <%String success=(String)request.getAttribute("success"); %>
    <%if(success!=null){ %>
    <h3 class="success" style="text-align: center;"><%=success %></h3>
    <%} %>
    <%String error=(String)request.getAttribute("error"); %>
    <%if(error!=null){ %>
    <h3 class="error" style="text-align: center;"><%=error %></h3>
    <%} %>
    


    

    <form action="Login" method="post" style="text-align: center;">
        <label>Enter your mail ID:</label><br>
        <input type="text" name="mail"><br><br>

        <label>Enter the password:</label><br>
        <input type="password" name="password"><br><br>

        <input type="submit" value="Login" 
               style="background-color: green; color: white; padding: 8px 16px; border: none; cursor: pointer;">
        &nbsp;&nbsp;

        <a href="forgotPassword.jsp">forgot password?</a><br><br>

        <span>Don't have a account? <a href="signup.jsp">signup</a></span>
    </form>

</body>
</html>
