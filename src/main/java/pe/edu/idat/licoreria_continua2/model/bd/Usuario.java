package pe.edu.idat.licoreria_continua2.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idusuario;
    private  String nickusuario;
    private  String correousuario;
    private  String password;
    private  String dniusuario;
    private  String nombreusuario;
    private  String apellidosusuario;
    private  Boolean activo;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol",joinColumns = @JoinColumn(name = "idusuario"),
            inverseJoinColumns = @JoinColumn(name = "idrol"))
    private Set<Rol> roles;

}
