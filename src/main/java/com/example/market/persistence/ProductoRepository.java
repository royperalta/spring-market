package com.example.market.persistence;

import com.example.market.persistence.Entity.Producto;
import com.example.market.persistence.crud.RepositoryCrudProductos;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private RepositoryCrudProductos repositoryCrudProductos;

    public List<Producto> getAll(){
        return (List<Producto>) repositoryCrudProductos.findAll();
    }
    public List<Producto> getByCategoria(int categoria){
        return repositoryCrudProductos.findByIdCategoriaOrderByNombreAsc(categoria);
    }
    public Optional <List<Producto>> getEscasos(int cantidad){
        return  repositoryCrudProductos.findByCantidadStockLessThanAndEstado(cantidad,true);
    }
}
