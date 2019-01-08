<%@taglib prefix="c" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
function search()
{
	
	 var x;
	if(window.XMLHttpRequest)
		x=new XMLHttpRequest();
	else
		x=new ActiveXObject("Microsoft.XMLHTTP"); 
		
	
	var nm=document.getElementById("state").value;
	var url="city.jlc?name="+nm;
	x.open("GET", url);
	
	x.onreadystatechange=function searchResponse()
	{
		if(x.readyState==4 && x.status==200)
			{
			
			var res=x.responseText;
			
			
			var data=eval('('+res+')'); 
			
			var a=document.getElementById("city");
			for(var k=a.length-1;k>0;k--)
				a.remove(k);
			
			
			
			for(var i=0;i<data.length;i++)
				{
				
				var s=data[i];
				
				var option = document.createElement('option');
				  option.value = s.city;
				  option.innerHTML = s.city;
				  document.getElementById("city").appendChild(option);
				  
				  if(s.city=="${city}")
					  {
					  a.value=s.city;
					  }  
			}
		}
		
	};
x.send();

}

window.onload=search;

function checkpermanent()
{
	 var check_Adress=document.getElementById("Check_per_address").checked; 
	
	if(check_Adress)
		{
	document.getElementById("hide_div").style="display:none";
	document.getElementById("per_village").value=document.getElementById("village").value;
	document.getElementById("per_post").value=document.getElementById("post").value;
	document.getElementById("per_street").value=document.getElementById("street").value;
	document.getElementById("per_houseno").value=document.getElementById("houseno").value;
	document.getElementById("per_country").value=document.getElementById("country").value;
	document.getElementById("per_state").value=document.getElementById("state").value;
	document.getElementById("per_city").value=document.getElementById("city").value;
	document.getElementById("per_pincode").value=document.getElementById("pincode").value;
		}
	else
		{
		document.getElementById("hide_div").style="display:block";
	
	document.getElementById("per_village").value="";
	document.getElementById("per_post").value="";
	document.getElementById("per_street").value="";
	document.getElementById("per_houseno").value="";
	document.getElementById("per_country").value="";
	document.getElementById("per_state").value="";
	document.getElementById("per_city").value="";
	document.getElementById("per_pincode").value="";
	}
}
	window.onload=checkpermanent;
	
	function Confirm()
	{
		
		 if(document.getElementById("confirm").checked)
			document.getElementById("submit").disabled=false; 
		 else
			 document.getElementById("submit").disabled=true; 
	}
</script>


<html>
<body>

<center><h1>Welcome to Login Page</h1></center>

<h3>${msg}</h3>

<c:form commandName="usercommand" action="submit.jlc">

<table>

<tr><td>Username:</td><td><c:input path="uname"/></td><td><font color="red"><c:errors path="uname"></c:errors></font></</td></tr>
<tr><td>Password:</td><td><c:input path="pass"/></td><td><font color="red"><c:errors path="pass"></c:errors></font></td></tr>
<tr><td>Full Name:</td><td><c:input path="name"/></td><td><font color="red"><c:errors path="name"></c:errors></font></</td></tr>
<tr><td>Father Name:</td><td><c:input path="fname"/></td><td><font color="red"><c:errors path="fname"></c:errors></font></td></tr>
<tr><td>Mother Name:</td><td><c:input path="mname"/></td><td><font color="red"><c:errors path="mname"></c:errors></font></td></tr>
<tr><td>Phone:</td><td><c:input path="phone" maxlength="10" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"/></td><td><font color="red"><c:errors path="phone"></c:errors></font></td></tr>
<tr><td>Adhar No:</td><td><c:input path="adhar"/></td><td><font color="red"><c:errors path="adhar"></c:errors></font></td></tr>


<tr><td style="size: 5;color: green">Present Address:</td></tr></br></br>

<tr><td>Village:</td><td><c:input path="village"/></td><td><font color="red"><c:errors path="village"></c:errors></font></td></tr>
<tr><td>Post:</td><td><c:input path="post"/></td><td><font color="red"><c:errors path="post"></c:errors></font></td></tr>
<tr><td>Street:</td><td><c:input path="street"/></td><td><font color="red"><c:errors path="street"></c:errors></font></td></tr>
<tr><td>House No:</td><td><c:input path="houseno"/></td><td><font color="red"><c:errors path="houseno"></c:errors></font></td></tr>
<tr><td>Pin Code:</td><td><c:input path="pincode"/></td><td><font color="red"><c:errors path="pincode"></c:errors></font></td></tr>

<tr><td>Country:</td>
<td><c:select path="country" id="country" onchange="">
<c:option value="" label="---select---"/>
<c:options items="${country}"/>
</c:select>
</td><td><font color="red"><c:errors path="country"></c:errors></font></td></tr>


<tr><td>State:</td>
<td><c:select path="state" id="state" onchange="search()">
<c:option value="" label="---select---"/>
<c:options items="${state}"/>
</c:select>
</td><td><font color="red"><c:errors path="state"></c:errors></font></td></tr>

<tr><td>City:</td>
<td><c:select path="city" id="city">
<c:option value="" label="---select---"/>
</c:select>
</td><td><font color="red"><c:errors path="city"></c:errors></font></td></tr>

</table>

</br>
<table>
<tr><td style="size:5;color: green">Permanent Address:</td></tr>
<tr><td style="color:blue;size: 5"><c:checkbox path="Check_per_address" id="Check_per_address" value="hello" onclick="checkpermanent()"/>Is your Permanent Address is same as Present Address</tr>
</table>

<div id="hide_div">
<table>
<tr><td>Village:</td><td><c:input path="per_village"/></td><td><font color="red"><c:errors path="per_village"></c:errors></font></td></tr>
<tr><td>Post:</td><td><c:input path="per_post"/></td><td><font color="red"><c:errors path="per_post"></c:errors></font></td></tr>
<tr><td>Street:</td><td><c:input path="per_street"/></td><td><font color="red"><c:errors path="per_street"></c:errors></font></td></tr>
<tr><td>House No:</td><td><c:input path="per_houseno"/></td><td><font color="red"><c:errors path="per_houseno"></c:errors></font></td></tr>
<tr><td>Pin Code:</td><td><c:input path="per_pincode"/></td><td><font color="red"><c:errors path="per_pincode"></c:errors></font></td></tr>

<tr><td>Country:</td>
<td><c:select path="per_country" id="per_country" onchange="">
<c:option value="" label="---select---"/>
<c:options items="${country}"/>
</c:select>
</td><td><font color="red"><c:errors path="per_country"></c:errors></font></td></tr>

<tr><td>State:</td>
<td><c:select path="per_state" id="per_state" onchange="search()">
<c:option value="" label="---select---"/>
<c:options items="${state}"/>
</c:select>
</td><td><font color="red"><c:errors path="per_state"></c:errors></font></td></tr>

<tr><td>City:</td>
<td><c:select path="per_city" id="per_city">
<c:option value="" label="---select---"/>
</c:select>
</td><td><font color="red"><c:errors path="per_city"></c:errors></font></td></tr>
</table>
</div>
</br>
<table>
<tr><td>Enter Captcha:</td><td><c:input path="captcha"/></td><td bgcolor="green"><font color="blue"><c:input path="gencaptcha" value="${captcha}" disabled="true"/></font></td><td><font color="red">${captchamsg}</font></td></tr>
<tr></tr>
<tr><td style="color: green;size: 5" ><c:checkbox path="confirm" id="confirm" value="Confirm" onclick="Confirm()" />You must agree with all all our terms and conditions</td></tr>
<tr></tr>
<tr></tr>
<tr><td colspan="2"><input type="submit" id="submit" value="Login" disabled="disabled"/></td></tr>
</table>

</c:form>


</body>
</html>