package pe.edu.idat.licoreria_continua2.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "despacho")
public class Despacho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer coddespacho;
    private String tipoenvio;
    private Date fechaenvio;
    private String direccionsalida;
    private String direccionllegada;
    private Date fechallegada;
    private Integer estado;
    private String transporte;
    private String personarecibir;

    @ManyToOne
    @JoinColumn(name="codventa")
    private VentaProducto ventaProducto;
}
