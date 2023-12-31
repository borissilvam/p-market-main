package tech.borissilvam.pmarket.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tech.borissilvam.pmarket.domain.Product;
import tech.borissilvam.pmarket.domain.repository.ProductRepository;
import tech.borissilvam.pmarket.persistence.crud.ProductoCrudRepository;
import tech.borissilvam.pmarket.persistence.entity.Producto;
import tech.borissilvam.pmarket.persistence.mapper.ProductMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = productoCrudRepository.findAll();

        return  mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int catroryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(catroryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);

        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        Optional<Producto> producto = productoCrudRepository.findById(productId);
        return producto.map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct( productoCrudRepository.save(producto));
    }
    @Override
    public void delete(int idProduct){
        productoCrudRepository.deleteById(idProduct);

    }




}
