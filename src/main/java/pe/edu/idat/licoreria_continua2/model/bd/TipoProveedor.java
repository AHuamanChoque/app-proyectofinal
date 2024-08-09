package pe.edu.idat.licoreria_continua2.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipoproveedor")
public class TipoProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codtipoprovee;
    private String descripcion;
}
