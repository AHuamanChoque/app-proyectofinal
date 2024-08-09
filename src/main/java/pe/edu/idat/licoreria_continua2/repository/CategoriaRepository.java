package pe.edu.idat.licoreria_continua2.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.idat.licoreria_continua2.model.bd.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {

@Modifying
@Transactional
@Query(value = "UPDATE categoria SET nombrecategoria=: nombrecategoria where codcategoria=: codcategoria",nativeQuery = true )
void actualizarCategoria(@Param("codcategoria")Integer codcategoria,
                         @Param("nombrecategoria") String nombrecategoria);

}
