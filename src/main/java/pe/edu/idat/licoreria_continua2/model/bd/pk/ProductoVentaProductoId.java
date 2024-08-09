package pe.edu.idat.licoreria_continua2.model.bd.pk;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class ProductoVentaProductoId implements Serializable {
    private Integer codventa;
    private String codproducto;

}
