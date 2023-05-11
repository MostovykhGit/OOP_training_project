<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>News</title>
</head>
<body>

<h2>News</h2>
<table>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>description</th>
    </tr>
    <c:forEach var="news" items="${allNews}">
        <tr>
            <td>${news.id}</td>
            <td>${news.title}</td>
            <td>${news.description}</td>
            <td>
                <a href="/delete/${news.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new news</a>
</body>
</html>