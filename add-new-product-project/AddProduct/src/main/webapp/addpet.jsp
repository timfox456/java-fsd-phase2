<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Pet</title>
<script src="addproduct.js"></script>
</head>
<body>


<form action="pets" method="post" name="form_name" id="form_id" class="form_class" >
  <label for="name">Name:</label><br>
  <input type="text" id="name" name="name"><br>
  <label for="color">Color:</label><br>
  <input type="text" id="color" name="color"><br>
  <label for="price">Price:</label><br>
  <input type="number" id="price" name="price"><br><br>
  <input type="submit" value="Submit" onclick="addpet_onclick()">
</form>



</body>
</html>