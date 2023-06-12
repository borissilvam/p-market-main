package tech.borissilvam.pmarket.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.borissilvam.pmarket.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findByIdCategoriaOrderByNombreAsc(Integer idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(Integer cantidad, Boolean estado);
}
