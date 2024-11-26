<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 25/11/2024
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Productos</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <h1 class="mt-5">Lista de Productos</h1>

  <div class="row">
    <!-- Ejemplo de producto 1 -->
    <div class="col-md-4">
      <div class="card">
        <div class="card-body">
          <h5 class="card-title">Laptop</h5>
          <p class="card-text">Precio: $523.25</p>
          <form action="add-to-cart" method="post">
            <input type="hidden" name="productId" value="1" />
            <button type="submit" class="btn btn-primary">Añadir al carrito</button>
          </form>
        </div>
      </div>
    </div>

    <!-- Ejemplo de producto 2 -->
    <div class="col-md-4">
      <div class="card">
        <div class="card-body">
          <h5 class="card-title">Cocina</h5>
          <p class="card-text">Precio: $325.24</p>
          <form action="add-to-cart" method="post">
            <input type="hidden" name="productId" value="2" />
            <button type="submit" class="btn btn-primary">Añadir al carrito</button>
          </form>
        </div>
      </div>
    </div>

    <!-- Ejemplo de producto 3 -->
    <div class="col-md-4">
      <div class="card">
        <div class="card-body">
          <h5 class="card-title">Mouse</h5>
          <p class="card-text">Precio: $15.25</p>
          <form action="add-to-cart" method="post">
            <input type="hidden" name="productId" value="3" />
            <button type="submit" class="btn btn-primary">Añadir al carrito</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
