package pe.edu.idat.licoreria_continua2.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "comprobantepago")
public class ComprobantePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcomprobantepago;
    private Date fechapago;
    private Double montopago;

    @ManyToOne
    @JoinColumn(name="idformapago")
    private FormaPago formaPago;
}
