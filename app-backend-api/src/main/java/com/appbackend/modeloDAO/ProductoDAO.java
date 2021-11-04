package com.appbackend.modeloDAO;

import com.appbackend.interfaces.ProductoInterface;
import com.appbackend.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProductoDAO implements ProductoInterface {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Map<String, Object>> listar() {
        List<Map<String, Object>> list = template.queryForList("select * from productos");
        return list;
    }

    @Override
    public List<Map<String, Object>> listarId(int id) {
        return null;
    }

    @Override
    public int add(Producto p) {
        String sql = "INSERT INTO productos(idProducto, producto, idMarca, descripcion, imagen, precio_costo, precio_venta, existencia, fecha_ingreso) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        return template.update(sql, p.getIdProducto(), p.getProducto(), p.getIdMarca(), p.getDescripcion(), p.getImagen(), p.getPrecioCosto(), p.getPrecioVenta(), p.getExistencia(), p.getFecha_ingreso());
    }

    @Override
    public int edit(Producto p) {
        String sql="UPDATE productos SET producto = ?, idMarca = ?, descripcion = ?, imagen = ?, precio_costo = ?, precio_venta = ?, existencia = ?, fecha_ingreso = ? WHERE idProducto = ? ";
        return template.update(sql, p.getProducto(), p.getIdMarca(), p.getDescripcion(), p.getImagen(), p.getPrecioCosto(), p.getPrecioVenta(), p.getExistencia(), p.getFecha_ingreso(), p.getIdProducto());
    }

    @Override
    public int delete(int id) {
        String sql="delete from productos where idProducto =?";
        return template.update(sql,id);
    }
}
