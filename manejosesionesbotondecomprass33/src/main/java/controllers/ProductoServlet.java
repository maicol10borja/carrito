package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Productos;
import services.LoginService;
import services.LoginServiceSessionImplement;
import services.ProductoService;
import services.ProductoServiceImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Crear el servicio de productos e invocar el método para obtener la lista de productos
        ProductoService servicios = new ProductoServiceImplement();
        List<Productos> productos = servicios.listar();

        // Verifica si el parámetro "addToCart" está presente en la URL (esto indica que el usuario ha seleccionado un producto para agregar al carrito)
        String productId = req.getParameter("addToCart");
        if (productId != null) {
            HttpSession session = req.getSession(); // Obtener la sesión del usuario
            List<Productos> cart = (List<Productos>) session.getAttribute("cart"); // Obtener el carrito desde la sesión
            if (cart == null) {
                cart = new ArrayList<>(); // Si no existe el carrito, crear una nueva lista
                session.setAttribute("cart", cart); // Guardar el carrito vacío en la sesión
            }
            // Buscar el producto seleccionado por su ID y agregarlo al carrito
            for (Productos p : productos) {
                if (String.valueOf(p.getIdProducto()).equals(productId)) {
                    cart.add(p); // Agregar el producto al carrito
                    break; // Salir del ciclo una vez que el producto ha sido agregado
                }
            }
        }

        // Crear un servicio de autenticación para obtener el nombre de usuario (si está autenticado)
        LoginService auth = new LoginServiceSessionImplement();
        Optional<String> usernameOptional = auth.getUsername(req);

        // Configurar el tipo de contenido de la respuesta como HTML
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            // Escribir el inicio de la página HTML
            out.print("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<title>Listado de productos</title>");
            out.println("<link href=\"");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container mt-5\">");
            out.println("<h1>Listado de productos</h1>");

            // Si el usuario está autenticado, mostrar un saludo personalizado
            if (usernameOptional.isPresent()) {
                out.println("<div class='alert alert-success'>Hola " + usernameOptional.get() + ", Bienvenido.</div>");
                out.println("<a href='/webapp_session/cart' class='btn btn-primary mb-3'>Ver carrito</a>");
            }

            // Crear una tabla para mostrar los productos
            out.println("<table class='table table-bordered'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>ID PRODUCTO</th>");
            out.println("<th>NOMBRE</th>");
            out.println("<th>CATEGORIA</th>");
            // Si el usuario está autenticado, mostrar también el precio y la opción de agregar al carrito
            if (usernameOptional.isPresent()) {
                out.println("<th>PRECIO</th>");
                out.println("<th>AGREGAR AL CARRITO</th>");
            }
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            // Recorrer la lista de productos y mostrar cada uno en una fila de la tabla
            for (Productos pr : productos) {
                out.println("<tr>");
                out.println("<td>" + pr.getIdProducto() + "</td>");
                out.println("<td>" + pr.getNombre() + "</td>");
                out.println("<td>" + pr.getCategoria() + "</td>");
                // Si el usuario está autenticado, agregar columnas para el precio y el botón de agregar al carrito
                if (usernameOptional.isPresent()) {
                    out.println("<td>$" + pr.getPrecio() + "</td>");
                    out.println("<td><a href='/webapp_session/productos?addToCart=" + pr.getIdProducto() + "' class='btn btn-success'>Agregar</a></td>");
                }
                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
            out.println("</div>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}

