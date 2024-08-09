package pe.edu.idat.licoreria_continua2.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.licoreria_continua2.model.dto.CargoDto;
import pe.edu.idat.licoreria_continua2.model.dto.CategoriaDto;
import pe.edu.idat.licoreria_continua2.model.dto.RespuestaGeneral;
import pe.edu.idat.licoreria_continua2.service.ICargoService;
import pe.edu.idat.licoreria_continua2.service.ICategoriaService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/cargo")
public class CargoController {

    private ICargoService iCargoService;

    @GetMapping("")
    public String frmCargo(Model model){
        model.addAttribute("listcargo",iCargoService.listarCargos());

        return "cargo/frmcargo"; //Aqui no se usa RESPONSE BODY porque es una vista!
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<CargoDto> listarCargos(){
        return iCargoService.listarCargos();

    }


    @PostMapping("/registrar")
    @ResponseBody
    public RespuestaGeneral guardarCargo(@RequestBody CargoDto cargoDto){
        String mensaje="Cargo registrado correctamente";
        boolean resultado= true;
        try {
            iCargoService.guardarCargos(cargoDto);
        }catch (Exception ex){
            mensaje="Error: Ocurrio un error al conectarse a la BD";
            resultado= false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }

}
