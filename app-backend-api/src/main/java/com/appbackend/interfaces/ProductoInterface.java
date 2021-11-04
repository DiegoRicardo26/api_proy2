package com.appbackend.interfaces;
import com.appbackend.modelo.Producto;
import java.util.List;
import java.util.Map;

public interface ProductoInterface {
    public List<Map<String, Object>> listar();
    public List<Map<String, Object>>listarId(int id);
    public int add(Producto p);
    public int edit(Producto p);
    public int delete(int id);
}
