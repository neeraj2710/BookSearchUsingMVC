<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 20-04-2024
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>No Books</title>
</head>
<body>
<h1>Sorry! No books of <%= (String) request.getAttribute("subject")%> found in our DB</h1>
</body>
</html>
