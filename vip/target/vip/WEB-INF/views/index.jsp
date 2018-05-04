<%@ page language="java" contentType="textml; charset=UTF-8"	pageEncoding="UTF-8"%>
<html>
<head>
	<title>Login</title>
		<meta charset="utf-8"/>
		<link href="/static/css/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1"/>
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>

	 <div class="main">
		<div class="login-form">
			<h1>Member Login</h1>
					<div class="head">
						<img src="/static/images/user.png" alt=""/>
					</div>
				<form action="login.do" method="post" >
						<input type="text"  name="name"  />
						<input type="password" name="password"  />

							<input type="submit"  value="LOGIN" />

					<p><a href="#">Forgot Password ?</a></p>
				</form>
			</div>

   					<div class="copy-right">
						<p>Copyright &copy; 2014.Company name All rights reserved.</p>
					</div>

		</div>


</body>
</html>