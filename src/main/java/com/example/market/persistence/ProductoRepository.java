package com.example.market.persistence;

import com.example.market.domain.Product;
import com.example.market.domain.repository.ProductRepository;
import com.example.market.persistence.Entity.Producto;
import com.example.market.persistence.crud.RepositoryCrudProductos;
import com.example.market.persistence.mapper.ProductMapper;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private RepositoryCrudProductos repositoryCrudProductos;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
       List<Producto> productos = (List<Producto>) repositoryCrudProductos.findAll();
       return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategoryId(int categoryId) {
        List<Producto> productos = repositoryCrudProductos.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = repositoryCrudProductos.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods->mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return repositoryCrudProductos.findById(productId).map(producto -> mapper
        .toProduct(producto));
    }

    public Optional <List<Producto>> getEscasos(int cantidad){
        return  repositoryCrudProductos.findByCantidadStockLessThanAndEstado(cantidad,true);
    }

    public Optional<Producto> getProducto(int idProducto){
        return repositoryCrudProductos.findById(idProducto);
    }
    @Override
    public Product save(Product product){
        Producto producto = mapper.toProdcuto(product);
        return mapper.toProduct(repositoryCrudProductos.save(producto));
    }
    @Override
     public void delete(int productId){
        repositoryCrudProductos.deleteById(productId);
     }



}
