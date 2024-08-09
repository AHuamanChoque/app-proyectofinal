package pe.edu.idat.licoreria_continua2.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idrol;
    private  String nombrerol;
    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> usuarios=new HashSet<>();
}
