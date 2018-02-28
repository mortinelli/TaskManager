<%--
  Created by IntelliJ IDEA.
  User: smatveev
  Date: 27.02.2018
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="Task" class="taskmanager.model.Task" scope="request" />
<jsp:setProperty name="Task" property="*" />

<html>
<head>
    <title>TaskForm</title>
</head>
<section>
    <h3><a href="index.html">Home</a></h3>
    <h2>${param.action == 'create' ? 'Create task' : 'Edit task'}</h2>
    <hr>

    <form method="post" action="tasks">
        <input type="hidden" name="id" value="${task.id}">
        <dl>
            <dt>StartDateTime:</dt>
            <dd><input type="datetime-local" value="${task.startDateTime}" name="startDateTime"></dd>
        </dl>
        <dl>
            <dl>
                <dt>EndDateTime:</dt>
                <dd><input type="datetime-local" value="${task.endDateTime}" name="endDateTime"></dd>
            </dl>
        </dl>
            <dl>
            <dt>Description:</dt>
            <dd><input type="text" value="${task.descriptions}" size=40 name="description"></dd>
        </dl>
        <dl>
            <dl>
                <dt>Repeatable:</dt>
                <c:if test="${task.repeatable eq true}" >
                <dd><input type="checkbox" value="${task.repeatable}" name="repeatable"  checked ></dd>
                </c:if>
                <c:if test="${task.repeatable eq false}" >
                    <dd><input type="checkbox" value="${task.repeatable}" name="repeatable"   ></dd>
                </c:if>
            </dl>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
<body>

</body>
</html>
