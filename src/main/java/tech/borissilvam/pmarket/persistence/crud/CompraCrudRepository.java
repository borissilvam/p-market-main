package tech.borissilvam.pmarket.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.borissilvam.pmarket.persistence.entity.Compra;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends JpaRepository<Compra, Integer> {

    Optional<List<Compra>> findByIdCliente(String idCliente);
}
