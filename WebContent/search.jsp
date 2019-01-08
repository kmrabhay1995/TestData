<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Welcome to Search page</h1></br></br>
<font color="red" size="4"><h2>${msg}</h2></font></br>
<form action="searchafter.jlc">
Please Enter User Name:<input type="text" name="un"/></br></br>
<input type="submit" value="Search"/>
</form>
</br>
<font color="blue"><h2>${msg1}</h2></font></br>
 <table border="2">
 
 <%if(request.getAttribute("ut")!=null)
	 {%>
	 <jsp:include page="table.jsp"/>
	 <%} %>
	 <h4>
 <c:forEach items="${ut}" var="ut">
<tr><td>${ut.uname}</td><td>${ut.pass}</td><td>${ut.fname}</td><td>${ut.mname}</td>
<td>${ut.phone}</td><td>${ut.add}</td><td>${ut.adhar}</td></tr>
</c:forEach>
</h4>
</table>

</body>
</html>