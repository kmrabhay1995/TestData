

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Welcome to Address page</h1></br></br>

<form action="getByAddress.jlc">
Please Enter Address:<input type="text" name="add"/></br></br>
<input type="submit" value="Get User"/>
</form></br></br>


<center><font color="red"><h3>${msg}</h3></font></center>
 <h3>
 <table border="2">
 
<% 
Object ob=request.getAttribute("ut");
if (ob!=null) { %>
          <jsp:include page="table.jsp" />
<% }%> 
 <c:forEach items="${ut}" var="ut">
<tr><td>${ut.uname}</td><td>${ut.pass}</td><td>${ut.fname}</td><td>${ut.mname}</td>
<td>${ut.phone}</td><td>${ut.add}</td><td>${ut.adhar}</td><td><a href="deletemain.jlc?uname=${ut.uname}">delete</a></td></tr>
</c:forEach>
</h3>
</body>
</html>