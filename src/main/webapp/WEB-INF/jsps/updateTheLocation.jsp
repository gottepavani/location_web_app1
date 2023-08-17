<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Locations</title>
</head>
<body>
<h2>Update Locations</h2>
<form action="updateLocationData" method="post">
id<input type="text" name="id" value="${id}"/>
code<input type="text" name="code" value="${code}"/>
name<input type="text" name="name" value="${name}"/>
type
urban<input type="radio" name="type" value="urban"/>
rural<input type="radio" name="type" value="rural"/>
<input type="Submit" value="update"/>

</form>
${updatemsg}

</body>
</html>