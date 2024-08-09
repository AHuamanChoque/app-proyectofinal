package pe.edu.idat.licoreria_continua2.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.idat.licoreria_continua2.model.bd.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE proveedor SET razonsocial=:razonsocial," +
            " rucproveedor=:rucproveedor, " + "telefonoproveedor=:telefonoproveedor," +
            " codtipoprovee=:codtipoprovee " + "where codproveedor = :codproveedor",nativeQuery = true)
    void actualizarProveedor(@Param("codproveedor")Integer codproveedor,
                            @Param("razonsocial")String razonsocial,
                            @Param("rucproveedor")String rucproveedor,
                            @Param("telefonoproveedor")String telefonoproveedor,
                            @Param("codtipoprovee")Integer codtipoprovee
                            );


}
