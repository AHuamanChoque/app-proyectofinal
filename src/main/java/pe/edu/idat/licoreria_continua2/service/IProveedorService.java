package pe.edu.idat.licoreria_continua2.service;

import pe.edu.idat.licoreria_continua2.model.bd.Producto;
import pe.edu.idat.licoreria_continua2.model.bd.Proveedor;
import pe.edu.idat.licoreria_continua2.model.dto.ProveedorDto;

import java.util.List;

public interface IProveedorService {

    List<ProveedorDto> listarProveedores();

    void guardarProveedor(ProveedorDto proveedor);
}
