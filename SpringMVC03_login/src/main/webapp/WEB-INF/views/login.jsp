<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.do" method="post">		
		<table border=1>
			<col width="100" />
			<col width="100" />
			
			<tr>
				<th>ID</th>
				<td><input type="text" name="memberid" /></td>
			</tr>
			
			<tr>
				<th>PW</th>
				<td><input type="password" name="memberpw" /></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="login" />
					<input type="button" value="register" onclick="location.href='registerform.do'" />
				</td> 
			</tr>
		</table>
	</form>
</body>
</html>