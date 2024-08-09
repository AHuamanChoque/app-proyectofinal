package pe.edu.idat.licoreria_continua2.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.idat.licoreria_continua2.model.dto.CargoDto;
import pe.edu.idat.licoreria_continua2.model.dto.TipoProveedorDto;
import pe.edu.idat.licoreria_continua2.service.ICargoService;
import pe.edu.idat.licoreria_continua2.service.ITipoProveedorService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/tipoproveedor")
public class TipoProveedorController {

    private ITipoProveedorService iTipoProveedorService;

    @GetMapping("")
    public String frmTipoProveedor(Model model){
        model.addAttribute("listtipoproveedor",iTipoProveedorService.listarTipoProveedores());

        return "tipoproveedor/frmtipoproveedor"; //Aqui no se usa RESPONSE BODY porque es una vista!
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<TipoProveedorDto> listarTipoProveedor(){
        return iTipoProveedorService.listarTipoProveedores();

    }
}
