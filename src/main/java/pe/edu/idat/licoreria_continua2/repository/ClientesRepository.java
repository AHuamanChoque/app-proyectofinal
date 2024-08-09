package pe.edu.idat.licoreria_continua2.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.idat.licoreria_continua2.model.bd.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE clientes SET dnicli=:dnicli,"+ " nombrecli=:nombrecli, " +
            "apellidocli=:apellidocli," + " celularcli=:celularcli," +
            "correocli=:correocli, edadcli=:edadcli," +
            "sexocli=:sexocli, direccioncli=:direccioncli where codclientes = :codclientes",nativeQuery = true)
    void actualizarClientes(@Param("codclientes")Integer codclientes,
                             @Param("dnicli")String dnicli,
                             @Param("nombrecli")String nombrecli,
                             @Param("apellidocli")String apellidocli,
                             @Param("celularcli")String celularcli,
                             @Param("correocli")String correocli,
                             @Param("edadcli")Integer edadcli,
                             @Param("sexocli")String sexocli,
                             @Param("direccioncli")String direccioncli
    );



}
