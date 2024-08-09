package pe.edu.idat.licoreria_continua2.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codproducto;
    private String nombreprod;
    private Double precioprod;
    private Integer stockprod;
    private String detalleprod;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name="codproveedor")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name="codcategoria")
    private Categoria categoria;


    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DetalleComprobante> ventaProducto = new HashSet<>();


    //@OneToMany(mappedBy = "producto",cascade = CascadeType.ALL,orphanRemoval = true )
    //private Set<DetalleComprobante> ventaproductos= new HashSet<>();
}
