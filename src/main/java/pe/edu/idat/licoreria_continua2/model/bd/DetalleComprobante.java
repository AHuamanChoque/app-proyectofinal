package pe.edu.idat.licoreria_continua2.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.idat.licoreria_continua2.model.bd.pk.ProductoVentaProductoId;

@Getter
@Setter
@Entity
@Table(name = "detallecomprobante")
public class DetalleComprobante {
    @EmbeddedId
    private ProductoVentaProductoId id;

    private Integer unidadesprod;
    private Double subtotal;

    @ManyToOne
    @MapsId("codventa")
    @JoinColumn(name="codventa")
    private VentaProducto ventaProducto;

    @ManyToOne
    @MapsId("codproducto")
    @JoinColumn(name="codproducto")
    private Producto producto;

}
