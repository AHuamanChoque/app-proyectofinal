package pe.edu.idat.licoreria_continua2.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.licoreria_continua2.model.dto.CategoriaDto;
import pe.edu.idat.licoreria_continua2.model.dto.ClientesDto;
import pe.edu.idat.licoreria_continua2.model.dto.ProveedorDto;
import pe.edu.idat.licoreria_continua2.model.dto.RespuestaGeneral;
import pe.edu.idat.licoreria_continua2.service.ICategoriaService;
import pe.edu.idat.licoreria_continua2.service.IClienteService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClientesController {

    private IClienteService iClienteService;

    @GetMapping("")
    public String frmClientes(Model model){
        model.addAttribute("listclientes",iClienteService.listarClientes());

        return "clientes/frmclientes"; //Aqui no se usa RESPONSE BODY porque es una vista!
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<ClientesDto> listarClientes(){
        return iClienteService.listarClientes();

    }


    @PostMapping("/registrar")
    @ResponseBody
    public RespuestaGeneral guardarCliente(@RequestBody ClientesDto clientesDto){
        String mensaje="Producto registrado correctamente";
        boolean resultado= true;
        try {
            iClienteService.guardarClientes(clientesDto);
        }catch (Exception ex){
            mensaje="Error: Ocurrio un error al conectarse a la BD";
            resultado= false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }




}
