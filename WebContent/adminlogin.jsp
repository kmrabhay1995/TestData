<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<h1>Welcome to LoginPage</h1></br></br>

<a href="alluser.jlc">Get all Users</a></br></br>
<a href="address.jlc">Get all user By Address</a></br></br>
<a href="search.jlc">Search User</a></br></br></br></br>
<a href="index.jsp">Login Page</a></br></br>

<center><font color="red"><h3>${msg}</h3></font></center>
 <h2>
 <table border="2">
 
	  <% 
Object ob=request.getAttribute("ut");
if (ob!=null) { %>
           <jsp:include page="table.jsp" />
<% }%> 
<h3> 
<c:forEach items="${ut}" var="ut">
<tr><td>${ut.uname}</td><td>${ut.pass}</td><td>${ut.fname}</td><td>${ut.mname}</td>
<td>${ut.phone}</td><td>${ut.add}</td><td>${ut.adhar}</td><td><a href="deletemain.jlc?uname=${ut.uname}">delete</a></td></tr>
</c:forEach>
</h3>

</body>
</html>