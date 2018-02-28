<%--
  Created by IntelliJ IDEA.
  User: smatveev
  Date: 15.02.2018
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:useBean id="Task" class="taskmanager.model.Task" scope="request" />
<jsp:setProperty name="Task" property="*" />

<style>
    .general {
        color: black;
    }

    .repeat {
        color: green;
    }
</style>

<html>
<head>
    <title>Tasks</title>
</head>
<body>
Hello mr. User!
Plays to yours tasks.
<hr>
<table border="1">
<tr>
    <th>ID</th>
    <th>startTime</th>
    <th>endTime</th>
    <th>description</th>
    <th>repeatable</th>
    <th>Action to</th>
    <th>Action to</th>
</tr>
<c:forEach var="Task" items="${tasks}" >

    <tr class="${Task.repeatable ? "general" : "repeat"}">
        <th><c:out value="${Task.id}"/> </th>
        <th><c:out value="${Task.startDateTime}"/></th>
        <th><c:out value="${Task.endDateTime}"/></th>
        <th><c:out value="${Task.descriptions}"/></th>
        <th><c:out value="${Task.repeatable}"/></th>
        <th><a href="/tasks?action=update&id=${Task.id}">Edit</a> </th>
        <th><a href="/tasks?action=remove&id=${Task.id}">Remove</a> </th>

    </tr>
</c:forEach>
</table>
<br>
<a href="tasks?action=create"> Add Task</a>
<br>
<a href="index.html"> Start page!</a>
</body>
</html>
