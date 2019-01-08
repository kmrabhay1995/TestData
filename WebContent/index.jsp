<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Welcome to Login Page</h1></br></br>
<font color="red" size="4">${msg}</font></br></br>
<form action="log.jlc">
Username:<input type="text" name="uname"/></br></br>
Password:<input type="text" name="pass"/></br></br>
<input type="submit" value="submit"/>
</form>
</br></br>
<a href="login.jlc">Signup</a></br></br>
<a href="forgot.jlc">Forgot Password</a></br></br>
<a href="adminform.jlc">Go to Admin Page</a></br></br>
</body>
</html>