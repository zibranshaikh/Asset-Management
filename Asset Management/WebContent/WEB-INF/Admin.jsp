<p1 align="right">
 <form action="./adminop" method="post">
<input type="hidden" value="${user}" name="userid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<center>
<h1>${head}</h1>
<h1>Welcome ${user}</h1>
<h1>${msg}</h1>
<h1>${msg1}</h1>
</center>
<pre>
<p align="left">
<h1><a href="./createEmp" >Create Customer</a></h1>
<h1><a href="./viewEmp" >View All Customer</a></h1>
<h1><a href="./changeAdpwd" >Change Password</a></h1>
</p>
</pre>
