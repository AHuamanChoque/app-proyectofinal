package pe.edu.idat.licoreria_continua2.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codclientes;
    private String dnicli;
    private String nombrecli;
    private String apellidocli;
    private String celularcli;
    private String correocli;
    private Integer edadcli;
    private String sexocli;
    private String direccioncli;
}
