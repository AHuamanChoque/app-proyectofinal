package pe.edu.idat.licoreria_continua2.model.dto;

import lombok.Data;

@Data
public class UsuarioRequest {
    private Integer idusuario;
    private String nickusuario;
    private String nombreusuario;
    private String apellidosusuario;
    private Boolean activo;
    private String dniusuario;
    private String correousuario;

}
