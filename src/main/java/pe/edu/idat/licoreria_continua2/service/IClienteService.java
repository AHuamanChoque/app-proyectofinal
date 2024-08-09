package pe.edu.idat.licoreria_continua2.service;

import pe.edu.idat.licoreria_continua2.model.bd.Cargo;
import pe.edu.idat.licoreria_continua2.model.bd.Clientes;
import pe.edu.idat.licoreria_continua2.model.dto.CargoDto;
import pe.edu.idat.licoreria_continua2.model.dto.ClientesDto;

import java.util.List;

public interface IClienteService {

    List<ClientesDto> listarClientes();

    void guardarClientes(ClientesDto clientes);
}
