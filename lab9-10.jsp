<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String taskName = request.getParameter("taskName");
    String priority = request.getParameter("priority");
    String status = request.getParameter("status");

    if (taskName != null && !taskName.trim().isEmpty()) {
        session.setAttribute("taskName", taskName);
        session.setAttribute("priority", priority);
        session.setAttribute("status", status);
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Task Management System</title>
</head>

<body>

    <h1>Task Management System</h1>

    <h2>Add New Task</h2>

    <form method="post">

        Task Name:
        <input type="text" name="taskName" required>

        <br><br>

        Priority:
        <select name="priority">
            <option>High</option>
            <option>Medium</option>
            <option>Low</option>
        </select>

        <br><br>

        Status:
        <select name="status">
            <option>Pending</option>
            <option>In Progress</option>
            <option>Completed</option>
        </select>

        <br><br>

        <input type="submit" value="Add Task">

    </form>

    <hr>

    <h2>Task List</h2>

    <table border="1" cellpadding="10">

        <tr>
            <th>ID</th>
            <th>Task Name</th>
            <th>Priority</th>
            <th>Status</th>
        </tr>

        <tr>
            <td>1</td>
            <td>Complete JSP Assignment</td>
            <td>High</td>
            <td>Pending</td>
        </tr>

        <tr>
            <td>2</td>
            <td>Study Java</td>
            <td>Medium</td>
            <td>In Progress</td>
        </tr>

        <tr>
            <td>3</td>
            <td>Submit Project</td>
            <td>High</td>
            <td>Completed</td>
        </tr>

        <%
            if (session.getAttribute("taskName") != null) {
        %>

        <tr>
            <td>4</td>
            <td><%= session.getAttribute("taskName") %></td>
            <td><%= session.getAttribute("priority") %></td>
            <td><%= session.getAttribute("status") %></td>
        </tr>

        <%
            }
        %>

    </table>

</body>
</html>
