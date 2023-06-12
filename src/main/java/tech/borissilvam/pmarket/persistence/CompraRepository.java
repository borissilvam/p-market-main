package tech.borissilvam.pmarket.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tech.borissilvam.pmarket.domain.Purchase;
import tech.borissilvam.pmarket.domain.repository.PurchaseRepository;
import tech.borissilvam.pmarket.persistence.crud.CompraCrudRepository;
import tech.borissilvam.pmarket.persistence.crud.ProductoCrudRepository;
import tech.borissilvam.pmarket.persistence.entity.Compra;
import tech.borissilvam.pmarket.persistence.entity.Producto;
import tech.borissilvam.pmarket.persistence.mapper.PurchaseMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        List<Compra> compras = compraCrudRepository.findAll();

        return  mapper.toPurchases(compras);
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {

        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getCompraProductos().forEach(compraProducto -> compraProducto.setCompras(compra));

        return mapper.toPurchase( compraCrudRepository.save(compra));
    }
}
