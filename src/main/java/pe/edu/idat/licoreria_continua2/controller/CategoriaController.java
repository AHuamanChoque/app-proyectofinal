package pe.edu.idat.licoreria_continua2.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.licoreria_continua2.model.bd.Categoria;
import pe.edu.idat.licoreria_continua2.model.bd.Proveedor;
import pe.edu.idat.licoreria_continua2.model.dto.CategoriaDto;
import pe.edu.idat.licoreria_continua2.model.dto.ProductoDto;
import pe.edu.idat.licoreria_continua2.model.dto.RespuestaGeneral;
import pe.edu.idat.licoreria_continua2.service.ICategoriaService;
import pe.edu.idat.licoreria_continua2.service.IProveedorService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/categoria")
public class CategoriaController {
    private ICategoriaService iCategoriaService;

    @GetMapping("")
    public String frmCategoria(Model model){
        model.addAttribute("listcategoria",iCategoriaService.listarCategorias());

        return "categoria/frmcategoria"; //Aqui no se usa RESPONSE BODY porque es una vista!
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<CategoriaDto> listarCategorias(){
        return iCategoriaService.listarCategorias();

    }


    @PostMapping("/registrar")
    @ResponseBody
    public RespuestaGeneral guardarCategoria(@RequestBody CategoriaDto categoriaDto){
        String mensaje="Categoria registrada correctamente";
        boolean resultado= true;
        try {
            iCategoriaService.guardarCategoria(categoriaDto);
        }catch (Exception ex){
            mensaje="Error: Ocurrio un error al conectarse a la BD";
            resultado= false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }


}
