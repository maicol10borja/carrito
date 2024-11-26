<%--
  Created by IntelliJ IDEA.
  User: ADMIN-ITQ
  Date: 20/11/2024
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulario de Login</title>
    <link href="">
</head>
<body>
<div class="container">
    <h1>Formulario de Login</h1>
    <form action="/webapp_session/login" method="post">
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" name="username" id="username" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" name="password" id="password" required>
        </div>
        <div class="mb-3">
            <button type="submit" class="btn btn-primary">Iniciar sesión</button>
        </div>
    </form>
</div>

<script src=""></script>
</body>
</html>
