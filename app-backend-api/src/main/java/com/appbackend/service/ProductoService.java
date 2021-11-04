package com.appbackend.service;

import com.appbackend.interfaces.ProductoInterface;
import com.appbackend.modelo.Producto;
import com.appbackend.modeloDAO.ProductoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductoService implements ProductoInterface {

    @Autowired
    ProductoDAO dao;

    @Override
    public List<Map<String, Object>> listar() {
        return dao.listar();
    }

    @Override
    public List<Map<String, Object>> listarId(int id) {
        return null;
    }

    @Override
    public int add(Producto p) {
        return dao.add(p);
    }

    @Override
    public int edit(Producto p) {
        return dao.edit(p);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }
}
