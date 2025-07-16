<%@page import="java.util.ArrayList"%>
<%@page import="in.bg.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>STUDENT MANAGEMENT SYSTEM</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f8f9fa;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    h1 {
      color: #002366;
    }

    .navbar-brand {
      font-weight: bold;
      font-size: 18px;
    }

    .nav-link {
      margin-right: 12px;
    }

    .btn-danger {
      margin-left: 12px;
    }

    .card {
      border: 1px solid #dee2e6;
      border-radius: 12px;
      background-color: #ffffff;
      box-shadow: 0 0 18px rgba(0, 0, 0, 0.05);
    }

    table thead {
      background-color: #e9ecef;
    }

    table td, table th {
      text-align: center;
      vertical-align: middle;
    }

    @media (max-width: 576px) {
      .navbar-nav {
        text-align: center;
      }

      .btn-danger {
        margin-top: 10px;
        margin-left: 0;
      }
    }
  </style>
</head>
<body>

<%
  Student s = (Student) session.getAttribute("student");
  if (s != null) {
%>

  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Welcome <%= s.getName() %></a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
              data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
              aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
        <ul class="navbar-nav align-items-center">
          <li class="nav-item">
            <a class="nav-link" href="resetPassword.jsp">Reset Password</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="updateAccount.jsp">Update Data</a>
          </li>
          <li class="nav-item">
            <form class="d-inline" action="logout" method="post">
              <input class="btn btn-danger" type="submit" value="Logout">
            </form>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="container mt-5">
    <h1 class="text-center mb-4">Dashboard</h1>

    <div class="card shadow-sm p-4">
      <h4 class="mb-3">Your Profile Details</h4>
      <table class="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Mail ID</th>
            <th>Branch</th>
            <th>Location</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getPhone() %></td>
            <td><%= s.getMail() %></td>
            <td><%= s.getBranch() %></td>
            <td><%= s.getLocation() %></td>
          </tr>
        </tbody>
      </table>
    </div>
    
    <div class="col-md-12">
    	<h3>Search User</h3>
    	<form class="form-inline" action="searchUser" method="post">
    		Enter the name of the Student here:
    		<input type="text" name="search">
    		<input type="submit" class="btn btn-primary" value="search">
    	</form>
    	<br>
    	
    	<%ArrayList<Student> users= (ArrayList<Student>)request.getAttribute("users"); %>
    	<table class="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Mail ID</th>
            <th>Branch</th>
            <th>Location</th>
          </tr>
        </thead>
        <tbody>
                  
        <%if(users!=null && !users.isEmpty()){ %>
        <% for(Student s1:users){ %>
        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getPhone() %></td>
            <td><%= s.getMail() %></td>
            <td><%= s.getBranch() %></td>
            <td><%= s.getLocation() %></td>
          </tr>
          <%} %>
          <%} %>
        </tbody>
      </table>
    </div>
  </div>

<% } else { %>
  <div class="container mt-5">
    <div class="alert alert-warning text-center" role="alert">
      Session expired! Please <a href="login.jsp" class="alert-link">login again</a>.
    </div>
  </div>
<% } %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
