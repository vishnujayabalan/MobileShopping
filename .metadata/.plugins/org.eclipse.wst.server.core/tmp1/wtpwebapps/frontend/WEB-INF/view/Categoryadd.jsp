<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>category</title>
</head>
<body>
<div class="container">
<h2>Manage Category </h2>
<form action="manage_category_create" method="post">
<div class="from-group">
<input type="text" name="id"  placeholder="Enter id"> 
<input type="text" name="name" placeholder="Enter name"> 
<input type="text" name="description" placeholder="Enter description"> 
<button type="submit" class="btn btn-success">Create</button>
</div>
</form>
</div>
<div class="container">          
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="category" items="${categoryList}">
			<tr>
				<td>${category.id}</td>
				<td>${category.name}</td>
				<td>${category.description}</td>
					
			<td><a href="<c:url value='/manage_category_delete/${category.id}' />">Delete</a></td>

			</tr>
		</c:forEach>
    </tbody>
  </table>
</div><br/>
<br/><center>
<form action="findCategory" >
<div class="from-group">
<input type="text" name="id" placeholder="Enter id">  
<button type="submit" class="btn btn-primary">Edit</button>
</div>
</form>
</center>
</body>
</html>