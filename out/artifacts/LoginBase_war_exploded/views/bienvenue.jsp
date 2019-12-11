<%--
  Created by IntelliJ IDEA.
  User: quentin
  Date: 11/12/2019
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <%
        if(session.getAttribute("nomUser") == null) {
            response.sendRedirect("/login");
        }
    %>
    <h1>Bienvenue ${nomUser}</h1>
    <form action="logout">
        <input type="submit" value="logout">
    </form>
</body>
</html>
