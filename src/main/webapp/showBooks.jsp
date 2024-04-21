<%@ page import="java.util.List" %>
<%@ page import="org.example.booksearchusingmvc.BookPojo" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 20-04-2024
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Books</title>
</head>
<body>
    <%
        List<BookPojo> bookList = (List<BookPojo>) request.getAttribute("bookList");
        String subject = (String) request.getAttribute("subject");
    %>
    <h2>Found <%= bookList.size()%> books of subject <%= subject%></h2>
    <table border="2">
        <tr><th>BookId</th><th>BookName</th><th>BookPrice</th><th>Subject</th></tr>
        <%
            for (BookPojo book : bookList) {
                out.println("<tr><td>"+book.getBookId()+"</td><td>"+book.getBookName()+"</td><td>"+book.getBookPrice()+"</td><td>"+book.getSubject()+"</td></tr>");
            }
        %>
    </table>
</body>
</html>
