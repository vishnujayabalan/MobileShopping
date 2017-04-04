<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>header</title>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li class="active"><a href="clickhome"><span class="glyphicon glyphicon-home"></span>HOME</a></li>
      <li><a href="about">ABOUT US</a></li>
      <li><a href="regis">REGISTER</a></li>
      <c:if test="${!empty thisadmin}">
      <li><a href="admin">ADMIN</a>
      </li>
      </c:if>
      <c:if test="${!empty thisuser }">
      <li><a href="cart">MYCART</a>
      </li>
      </c:if>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <c:if test="${empty loginsuccess }">  
    <li><a href="clicklog"><span class="glyphicon glyphicon-user"></span>Login</a></li>
    </c:if>
    <c:if test="${!empty loginsuccess }">  
 <li><a href="clickhome"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
 </c:if>
 </ul>        
  </div>
</nav>
</body>
</html>