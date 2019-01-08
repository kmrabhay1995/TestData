<%@taglib prefix="c" uri="http://www.springframework.org/tags/form" %>


<html>
<body>

<h1>Welcome to Login Page</h1></br></br>

<h3>${msg}</h3>

<c:form commandName="usercommand" action="updateafter.jlc">

<table>

<tr><td>Username:</td><td><c:input path="uname" value="${ut.uname}" disabled="true"/></td><td><font color="red"><c:errors path="uname"></c:errors></font></</td></tr>
<tr><td>Password:</td><td><c:input path="pass" value="${ut.pass}"/></td><td><font color="red"><c:errors path="pass"></c:errors></font></td></tr>
<tr><td>Father Name:</td><td><c:input path="fname" value="${ut.fname}"/></td><td><font color="red"><c:errors path="fname"></c:errors></font></td></tr>
<tr><td>Mother Name:</td><td><c:input path="mname" value="${ut.mname}"/></td><td><font color="red"><c:errors path="mname"></c:errors></font></td></tr>
<tr><td>Phone:</td><td><c:input path="phone" value="${ut.phone}"/></td><td><font color="red"><c:errors path="phone"></c:errors></font></td></tr>
<tr><td>Address:</td><td><c:input path="add" value="${ut.address}"/></td><td><font color="red"><c:errors path="add"></c:errors></font></td></tr>
<tr><td>Adhar No:</td><td><c:input path="adhar" value="${ut.adhar}"/></td><td><font color="red"><c:errors path="adhar"></c:errors></font></td></tr>

<tr><td colspan="2"><input type="submit" value="update"/></td></tr>
</table>

</c:form>


</body>
</html>