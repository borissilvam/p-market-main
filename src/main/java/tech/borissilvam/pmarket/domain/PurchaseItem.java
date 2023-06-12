package tech.borissilvam.pmarket.domain;

import lombok.Data;

@Data
public class PurchaseItem {

    private int productId;

    private int quantity;
    private double total;
    private boolean active;

}
