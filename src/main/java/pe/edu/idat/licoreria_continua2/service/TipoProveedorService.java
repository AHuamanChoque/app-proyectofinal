package pe.edu.idat.licoreria_continua2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.licoreria_continua2.model.bd.Cargo;
import pe.edu.idat.licoreria_continua2.model.bd.TipoProveedor;
import pe.edu.idat.licoreria_continua2.model.dto.CargoDto;
import pe.edu.idat.licoreria_continua2.model.dto.TipoProveedorDto;
import pe.edu.idat.licoreria_continua2.repository.ProveedorRepository;
import pe.edu.idat.licoreria_continua2.repository.TipoProveedorRepository;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class TipoProveedorService implements ITipoProveedorService {

    private TipoProveedorRepository tipoProveedorRepository;
    @Override
    public List<TipoProveedorDto> listarTipoProveedores() {
        List<TipoProveedorDto>tipoProveedorDtoList = new ArrayList<>();
        for (TipoProveedor tipoprove : tipoProveedorRepository.findAll()){
            TipoProveedorDto tipoProveedorDto =TipoProveedorDto.builder().codtipoprovee(tipoprove.getCodtipoprovee())
                    .descripcion(tipoprove.getDescripcion())
                    .build();
            tipoProveedorDtoList.add(tipoProveedorDto);

        }
        return tipoProveedorDtoList;
    }

    @Override
    public void guardarTipoProveedor(TipoProveedorDto tipoProveedor) {

    }
}
