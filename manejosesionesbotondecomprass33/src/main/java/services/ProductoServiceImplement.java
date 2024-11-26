package services;

import models.Productos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductoServiceImplement implements ProductoService {
    @Override
    public List<Productos> listar() {
        List<Productos> productos = new ArrayList<>();
        productos.add(new Productos(1, "Televisor Lg", "Electronica", 699.0));
        productos.add(new Productos(2, "Phone 11", "Electronica", 799.0));
        productos.add(new Productos(3, "Refigeradora", "Linea Blanca", 820.0));
        productos.add(new Productos(4, "Ventilador", "Electronica", 320.0));
        productos.add(new Productos(5, "Lavadora", "Linea Blanca", 650.0));
        productos.add(new Productos(6, "Parlante Sonny", "Electronica", 450.0));
        return productos;
    }
}
