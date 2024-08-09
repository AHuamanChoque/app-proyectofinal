package pe.edu.idat.licoreria_continua2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.licoreria_continua2.model.bd.VentaProducto;

@Repository
public interface VentaProductoRepository extends JpaRepository<VentaProducto,Integer> {
}
