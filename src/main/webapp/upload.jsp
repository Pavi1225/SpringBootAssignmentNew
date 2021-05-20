<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
#bor-der {
  border-radius: 10px;
  background-color: #f2f2f2;
  padding: 20px;
  max-width: 500px;
  margin: auto;
  text-align:center;
}
</style>

<body>
<div id="bor-der">
<header>
<h1>Upload Excel Data</h1>
</header>
<form method="POST" enctype="multipart/form-data" action="readData" >
<div>Choose your Excel sheet: <input type="file" name="excelData"/><br></div>
<br>
<div><input type="submit" value="Upload"/><br></div>
</form>
</div>
</body>
</html>