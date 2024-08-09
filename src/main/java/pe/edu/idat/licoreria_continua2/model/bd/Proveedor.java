package pe.edu.idat.licoreria_continua2.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codproveedor;
    private String razonsocial;
    private String rucproveedor;
    private String telefonoproveedor;

    @ManyToOne
    @JoinColumn(name="codtipoprovee")
    private TipoProveedor tipoProveedor;
}
