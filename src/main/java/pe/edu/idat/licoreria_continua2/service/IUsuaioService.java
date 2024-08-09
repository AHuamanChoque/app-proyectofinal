package pe.edu.idat.licoreria_continua2.service;

import pe.edu.idat.licoreria_continua2.model.bd.Usuario;

import java.util.List;

public interface IUsuaioService {
    Usuario obtenerUsuarioxNickusuario(String nickusuario);
    Usuario guardarUsuario(Usuario usuario);
    List<Usuario> listarUsuario();
    Usuario obtenerUsuarioxId(Integer id);
    /*void actualizarUsuario(Usuario usuario);*/

}
