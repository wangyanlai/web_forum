<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="margin: -2px">
	<iframe src="head.jsp" scrolling="no" width="100%" height="100%"></iframe>
	<%response.sendRedirect(request.getContextPath()+"/GetDataAction_getData");%>
</body>
</html>