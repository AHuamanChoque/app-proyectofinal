package pe.edu.idat.licoreria_continua2.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.idat.licoreria_continua2.model.dto.ClientesDto;
import pe.edu.idat.licoreria_continua2.model.dto.ColaboradorDto;
import pe.edu.idat.licoreria_continua2.service.ICategoriaService;
import pe.edu.idat.licoreria_continua2.service.IColaboradorService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/colaborador")
public class ColaboradorController {

    private IColaboradorService iColaboradorService;

    @GetMapping("")
    public String frmColaborador(Model model){
        model.addAttribute("listcolaborador",iColaboradorService.listarColaboradores());

        return "colaborador/frmcolaborador"; //Aqui no se usa RESPONSE BODY porque es una vista!
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<ColaboradorDto> listarColaboradores(){
        return iColaboradorService.listarColaboradores();

    }



}
