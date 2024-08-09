package pe.edu.idat.licoreria_continua2.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ventaproducto")
public class VentaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codventa;
    private Date fechaventa;
    private Double descuentoventa;
    private Double montototal;
    private String tipocomprobante;

    @ManyToOne
    @JoinColumn(name="codcolaborador")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name="codclientes")
    private Clientes clientes;

    @ManyToOne
    @JoinColumn(name="idcomprobantepago")
    private ComprobantePago comprobantePago;

    @OneToMany(mappedBy = "ventaProducto",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DetalleComprobante> producto = new HashSet<>();


    //@OneToMany(mappedBy = "ventaProducto",cascade = CascadeType.ALL,orphanRemoval = true)
    //private Set<DetalleComprobante> productos = new HashSet<>();
}
