package pe.edu.idat.licoreria_continua2.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.licoreria_continua2.model.bd.Usuario;
import pe.edu.idat.licoreria_continua2.model.dto.RespuestaGeneral;
import pe.edu.idat.licoreria_continua2.model.dto.UsuarioRequest;
import pe.edu.idat.licoreria_continua2.service.IUsuaioService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/seguridad")
public class SeguridadController {
    private IUsuaioService iUsuaioService;

    @GetMapping("/usuario/registro")
    public String frmUsuario(Model model){
        model.addAttribute("listausuarios",
                iUsuaioService.listarUsuario());
        return "seguridad/frmusuario";
    }

    @PostMapping("/usuario")
    @ResponseBody
    public RespuestaGeneral registrarUsuario(
            @RequestBody UsuarioRequest usuarioRequest)
    {
        String mensaje = "Usuario registrado correctamente";
        boolean respuesta = true;
        try {
            Usuario usuario = new Usuario();
            usuario.setNombreusuario(usuarioRequest.getNombreusuario());
            usuario.setApellidosusuario(usuarioRequest.getApellidosusuario());
            if(usuarioRequest.getIdusuario() > 0){
                usuario.setIdusuario(usuarioRequest.getIdusuario());
                usuario.setActivo(usuarioRequest.getActivo());

                /*iUsuaioService.actualizarUsuario(usuario);*/
            }else{
                usuario.setNickusuario(usuarioRequest.getNickusuario());
                usuario.setCorreousuario(usuarioRequest.getCorreousuario());
                iUsuaioService.guardarUsuario(usuario);
            }
        }catch (Exception ex){
            mensaje = "Error al conectarse a la base de datos";
            respuesta = false;
        }
        return RespuestaGeneral.builder()
                .mensaje(mensaje)
                .resultado(respuesta).build();
    }


    @GetMapping("/usuario/{id}")
    @ResponseBody
    public Usuario obtenerUsuario(
            @PathVariable("id") int id){
        return iUsuaioService.obtenerUsuarioxId(id);
    }


    @GetMapping("/usuario")
    @ResponseBody
    public List<Usuario> listarUsuario(){

        return iUsuaioService.listarUsuario();
    }

}
