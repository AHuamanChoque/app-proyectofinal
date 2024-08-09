package pe.edu.idat.licoreria_continua2.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.idat.licoreria_continua2.model.bd.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
                                    @Modifying
                                    @Transactional
                                    @Query(value = "UPDATE producto SET nombreprod=:nombreprod," +
                                    " precioprod=:precioprod, " + "codcategoria=:codcategoria, codproveedor=:codproveedor, activo=:activo " +
                                    "where codproducto = :codproducto",nativeQuery = true)
    void actualizarProducto(@Param("codproducto")Integer codproducto,
                            @Param("nombreprod")String nombreprod,
                            @Param("precioprod")Double precioprod,
                            @Param("codcategoria")Integer codcategoria,
                            @Param("codproveedor")Integer codproveedor,
                            @Param("activo")boolean activo);

}
