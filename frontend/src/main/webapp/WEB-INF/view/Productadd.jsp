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
<title>product</title>
</head>
<body>
<h2><center>Manage Product</center></h2>
<br/>
    <div class="container">          
     <table class="table table-bordered">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>CategoryID</th>
        <th>SupplierID</th>
         <th>Price</th>
         <th>Quantity</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="product" items="${productList}">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.categoryid}</td>
				<td>${product.supplierid}</td>
                  <td>${product.price}</td>
                  <td>${product.quantity}</td>	
			<td><a href="<c:url value='/manage_product_delete/${product.id}' />">Delete</a></td>

			</tr>
		</c:forEach>
    </tbody>
  </table>
</div>
<center>
<div class="container">
<form action="findProduct" >
<div class="from-group">
<input type="text" name="id" placeholder="Enter id">  
<button type="submit" class="btn btn-primary">Edit</button>
</div>
</form>
<br>
<a href="createproduct">Add Product</a>
</div>
</center>
</body>
</html>