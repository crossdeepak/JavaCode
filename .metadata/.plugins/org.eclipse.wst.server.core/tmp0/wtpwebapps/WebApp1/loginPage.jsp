<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<div align="center">
		LoginPage
			<form name="loginFrm" action="LoginServlet" method="post">
				<table>
					<tr>
						<td>Username:-</td>
						<td><input type="text" name="userName"></td>
					</tr>
					<tr>
						<td>Password:-</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td><input type="submit" name="submit"></td>
					</tr>
				</table>
			</form>
	</div>
</body>
</html>