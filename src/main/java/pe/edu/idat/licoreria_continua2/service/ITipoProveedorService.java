package pe.edu.idat.licoreria_continua2.service;

import pe.edu.idat.licoreria_continua2.model.dto.CargoDto;
import pe.edu.idat.licoreria_continua2.model.dto.TipoProveedorDto;

import java.util.List;

public interface ITipoProveedorService {
    List<TipoProveedorDto> listarTipoProveedores();

    void guardarTipoProveedor(TipoProveedorDto tipoProveedor);


}
