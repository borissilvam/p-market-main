package tech.borissilvam.pmarket.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "compras_productos")
@Data
public class CompraProducto {
    @EmbeddedId
    private CompraProductoPK id;

    private Integer cantidad;
    private Double total;

    private Boolean estado;

    @MapsId("idCompra")
    @ManyToOne
    @JoinColumn(name = "id_compra" , insertable = false, updatable = false)
    private Compra compras;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;



}
