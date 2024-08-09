package pe.edu.idat.licoreria_continua2.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.idat.licoreria_continua2.model.bd.Rol;
import pe.edu.idat.licoreria_continua2.model.bd.Usuario;
import pe.edu.idat.licoreria_continua2.repository.RolRepository;
import pe.edu.idat.licoreria_continua2.repository.UsuarioRepository;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService implements IUsuaioService{

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder
            = new BCryptPasswordEncoder();

    @Override
    public Usuario obtenerUsuarioxNickusuario(String nickusuario) {
        return usuarioRepository.findByNickusuario(nickusuario);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        usuario.setPassword(bCryptPasswordEncoder.encode("123456"));
        usuario.setActivo(true);
        Rol usuarioRol = rolRepository.findByNombrerol("USER");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuarioxId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }



    /*@Override
    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.actualizarUsuario(usuario.getNombreusuario(), usuario.getApellidosusuario(),
                usuario.getActivo(), usuario.getIdusuario());
    }*/
}
