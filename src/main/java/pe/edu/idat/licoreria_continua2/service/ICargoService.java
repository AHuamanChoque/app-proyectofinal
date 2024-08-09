package pe.edu.idat.licoreria_continua2.service;

import pe.edu.idat.licoreria_continua2.model.bd.Cargo;
import pe.edu.idat.licoreria_continua2.model.bd.Categoria;
import pe.edu.idat.licoreria_continua2.model.dto.CargoDto;
import pe.edu.idat.licoreria_continua2.model.dto.CategoriaDto;

import java.util.List;

public interface ICargoService {

    List<CargoDto> listarCargos();

    void guardarCargos(CargoDto cargo);
}
