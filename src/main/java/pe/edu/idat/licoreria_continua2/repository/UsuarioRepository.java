package pe.edu.idat.licoreria_continua2.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.idat.licoreria_continua2.model.bd.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
Usuario findByNickusuario(String nickusuario);

/*@Modifying
@Transactional
@Query(value = "UPDATE usuario SET nombreusuario=: nombreusuario, apellidosusuario=: apellidosusuario, "+
        "activo=:activo where idusuario=: idusuario",nativeQuery = true )
void actualizarUsuario(@Param("nombreusuario")String nombreusuario,
                       @Param("apellidosusuario")String apellidosusuario,
                       @Param("activo")boolean activo,
                       @Param("idusuario")Integer idusuario);*/

}
