package pe.edu.idat.licoreria_continua2.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.licoreria_continua2.model.bd.Proveedor;
import pe.edu.idat.licoreria_continua2.model.dto.ProductoDto;
import pe.edu.idat.licoreria_continua2.model.dto.ProveedorDto;
import pe.edu.idat.licoreria_continua2.model.dto.RespuestaGeneral;
import pe.edu.idat.licoreria_continua2.service.IProveedorService;

import java.util.List;

@Controller
@RequestMapping("/proveedor")
@AllArgsConstructor
public class ProveedorController {
    private IProveedorService iProveedorService;

    @GetMapping("")
    public String frmProveedor(Model model){
        model.addAttribute("listproveedor",iProveedorService.listarProveedores());

        return "proveedor/frmproveedor"; //Aqui no se usa RESPONSE BODY porque es una vista!
    }


    @GetMapping("/listar")
    @ResponseBody
    public List<ProveedorDto> listarProveedores(){

        return iProveedorService.listarProveedores();
    }

    @PostMapping("/registrar")
    @ResponseBody
    public RespuestaGeneral guardarProveedor(@RequestBody ProveedorDto proveedorDto){
        String mensaje="Producto registrado correctamente";
        boolean resultado= true;
        try {
            iProveedorService.guardarProveedor(proveedorDto);
        }catch (Exception ex){
            mensaje="Error: Ocurrio un error al conectarse a la BD";
            resultado= false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }



}
