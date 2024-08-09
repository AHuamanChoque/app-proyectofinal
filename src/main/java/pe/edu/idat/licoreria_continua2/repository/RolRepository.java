package pe.edu.idat.licoreria_continua2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.licoreria_continua2.model.bd.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {

    Rol findByNombrerol(
            String nombrerol);
}
