<%@ page import ="com.cg.bean.*" language="java"%>
<html>
<body>
	<div>
	<%UserBean user=(UserBean)request.getAttribute("userBean"); %>
		<font color='green'>Welcome :-<%=user.getUserName() %></font>
	</div>
</body>
</html>