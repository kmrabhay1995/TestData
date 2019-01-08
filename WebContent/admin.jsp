<html>
<body>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Welcome to Admin Login page</h1></br></br>


<font color="red" size="4">${msg}</font></br></br>
<form action="admin.jlc">
Username:<input type="text" name="uname"/></br></br>
Password:<input type="text" name="pass"/></br></br>
<input type="submit" value="submit"/>
</form>
</br></br>
<a href="index.jsp">Go to Main page</a></br></br>



</body>
</html>