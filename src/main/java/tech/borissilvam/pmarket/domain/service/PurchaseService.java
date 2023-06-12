package tech.borissilvam.pmarket.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.borissilvam.pmarket.domain.Purchase;
import tech.borissilvam.pmarket.persistence.CompraRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private CompraRepository compraRepository;

    public List<Purchase> getALL() {
        return compraRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraRepository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase){
        return compraRepository.save(purchase);
    }
}
