package pe.edu.idat.licoreria_continua2.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ColaboradorDto {


    private String codcolaborador;
    private String nombrecol;
    private String apellidocol;
    private String telefonocol;
    private String correocol;
    private String dnicol;
    private Integer estado;
    private Integer codcargo;
    private String nombrecargo;

}
