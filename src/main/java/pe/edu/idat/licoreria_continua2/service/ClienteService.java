package pe.edu.idat.licoreria_continua2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.licoreria_continua2.model.bd.Categoria;
import pe.edu.idat.licoreria_continua2.model.bd.Clientes;
import pe.edu.idat.licoreria_continua2.model.bd.Proveedor;
import pe.edu.idat.licoreria_continua2.model.bd.TipoProveedor;
import pe.edu.idat.licoreria_continua2.model.dto.CategoriaDto;
import pe.edu.idat.licoreria_continua2.model.dto.ClientesDto;
import pe.edu.idat.licoreria_continua2.repository.ClientesRepository;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ClienteService implements IClienteService{
    private  ClientesRepository clientesRepository;

    @Override
    public List<ClientesDto> listarClientes() {
        List<ClientesDto>clientesDtoList = new ArrayList<>();
        for (Clientes clie : clientesRepository.findAll()){
            ClientesDto clientesDto =ClientesDto.builder().codclientes(clie.getCodclientes())
                    .dnicli(clie.getDnicli())
                    .nombrecli(clie.getNombrecli())
                    .apellidocli(clie.getApellidocli())
                    .celularcli(clie.getCelularcli())
                    .correocli(clie.getCorreocli())
                    .edadcli(clie.getEdadcli())
                    .sexocli(clie.getSexocli())
                    .direccioncli(clie.getDireccioncli())
                    .build();
            clientesDtoList.add(clientesDto);

        }
        return clientesDtoList;
    }



    @Override
    public void guardarClientes(ClientesDto clientes) {
        if( clientes.getCodclientes() >0){
            clientesRepository.actualizarClientes(
                    clientes.getCodclientes(),
                    clientes.getDnicli(),
                    clientes.getNombrecli(),
                    clientes.getApellidocli(),
                    clientes.getCelularcli(),
                    clientes.getCorreocli(),
                    clientes.getEdadcli(),
                    clientes.getSexocli(),
                    clientes.getDireccioncli());

        }else{
            Clientes nuevoCliente = new Clientes();
            nuevoCliente.setDnicli(clientes.getDnicli());
            nuevoCliente.setNombrecli(clientes.getNombrecli());
            nuevoCliente.setApellidocli(clientes.getNombrecli());
            nuevoCliente.setCelularcli(clientes.getCelularcli());
            nuevoCliente.setCorreocli(clientes.getCorreocli());
            nuevoCliente.setEdadcli(clientes.getEdadcli());
            nuevoCliente.setSexocli(clientes.getSexocli());
            nuevoCliente.setDireccioncli(clientes.getDireccioncli());


            clientesRepository.save(nuevoCliente);

        }
    }
}
