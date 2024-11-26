package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Productos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/cart")
public class CarritoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener la sesión del usuario y recuperar el carrito (si existe)
        HttpSession session = req.getSession();
        List<Productos> cart = (List<Productos>) session.getAttribute("cart");

        // Configurar el tipo de contenido de la respuesta como HTML
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            // Escribir el inicio de la página HTML
            out.print("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<title>Carrito de compras</title>");
            out.println("<link href=\"");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container mt-5\">");
            out.println("<h1>Carrito de compras</h1>");

            // Verificar si el carrito está vacío
            if (cart == null || cart.isEmpty()) {
                out.println("<div class='alert alert-warning'>El carrito está vacío.</div>");
            } else {
                // Mostrar los productos en el carrito en una tabla
                out.println("<table class='table table-bordered'>");
                out.println("<thead><tr><th>Producto</th><th>Precio</th></tr></thead>");
                out.println("<tbody>");
                double total = 0; // Inicializar el total del carrito
                // Recorrer los productos en el carrito y mostrarlos en la tabla
                for (Productos p : cart) {
                    out.println("<tr>");
                    out.println("<td>" + p.getNombre() + "</td>");
                    out.println("<td>$" + p.getPrecio() + "</td>");
                    out.println("</tr>");
                    total += p.getPrecio(); // Acumular el precio de cada producto al total
                }
                // Mostrar el total en una fila adicional
                out.println("<tr><td><strong>Total</strong></td><td><strong>$" + total + "</strong></td></tr>");
                out.println("</tbody>");
                out.println("</table>");
            }
            // Botón para volver a la página de productos
            out.println("<a href='/webapp_session/productos' class='btn btn-primary'>Volver a productos</a>");
            out.println("</div>");
            out.println("<script src=\"\"></script>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}


