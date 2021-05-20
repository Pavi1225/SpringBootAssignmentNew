<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head><style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
   max-width: 500px;
  margin: auto;
}
</style>
<body>
<table  border="1" cellpadding="2" cellspacing="2">
<tr>
<th>EmployeeId</th>
<th>EmployeeName</th>
<th>Department</th>
<th>Mobile</th>
</tr>
  <c:forEach var="item" items="${employeeData}" >
    <tr>
      <td><c:out value="${item.employeeId}" /></td>
      <td><c:out value="${item.employeeName}" /></td>
      <td><c:out value="${item.department}" /></td>
      <td><c:out value="${item.mobile}" /></td>
    </tr>
  </c:forEach>

</table>
</body>
</html>
