package pe.edu.idat.licoreria_continua2.service;

import pe.edu.idat.licoreria_continua2.model.bd.Cargo;
import pe.edu.idat.licoreria_continua2.model.bd.Colaborador;
import pe.edu.idat.licoreria_continua2.model.dto.CargoDto;
import pe.edu.idat.licoreria_continua2.model.dto.ColaboradorDto;

import java.util.List;

public interface IColaboradorService {

    List<ColaboradorDto> listarColaboradores();

    Colaborador guardarColaboradores(Colaborador colaborador);

}
