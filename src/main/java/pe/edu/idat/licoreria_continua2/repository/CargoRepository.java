package pe.edu.idat.licoreria_continua2.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.idat.licoreria_continua2.model.bd.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE cargo SET nombrecargo=: nombrecargo where codcargo=: codcargo",nativeQuery = true )
    void actualizarCargo(@Param("codcargo")Integer codcargo,
                             @Param("nombrecargo") String nombrecargo);

}
