package pe.edu.idat.licoreria_continua2.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.licoreria_continua2.model.dto.ProductoDto;
import pe.edu.idat.licoreria_continua2.model.dto.RespuestaGeneral;
import pe.edu.idat.licoreria_continua2.service.IProductoService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/producto")
public class ProductController {
    private IProductoService iProductoService;

    @GetMapping("")
    public String frmProducto(Model model){
        model.addAttribute("listproduct",iProductoService.listarProductos());

        return "producto/frmproducto"; //Aqui no se usa RESPONSE BODY porque es una vista!
    }

    @GetMapping("/listar")
    @ResponseBody //cuando devuelves un arreglo que no es una vista!
    public List<ProductoDto> listarproductos(){

        return iProductoService.listarProductos();
    }

    @PostMapping("/registrar")
    @ResponseBody
    public RespuestaGeneral guardarProducto(@RequestBody ProductoDto productoDto){
        String mensaje="Producto registrado correctamente";
        boolean resultado= true;
        try {
            iProductoService.guardarProducto(productoDto);
        }catch (Exception ex){
            mensaje="Error: Ocurrio un error al conectarse a la BD";
            resultado= false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }
}
