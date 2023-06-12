package tech.borissilvam.pmarket.domain.repository;

import tech.borissilvam.pmarket.domain.Product;
import tech.borissilvam.pmarket.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int catroryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
