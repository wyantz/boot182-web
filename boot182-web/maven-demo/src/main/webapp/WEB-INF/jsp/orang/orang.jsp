<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orang</title>
</head>
<body>
	<table border="1">
	<c:forEach items="${budiList}" var="ol">
		<tr>
			<td>${ol.nama}</td>
			<td>${ol.alamat}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>