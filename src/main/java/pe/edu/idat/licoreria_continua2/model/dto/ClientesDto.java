package pe.edu.idat.licoreria_continua2.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientesDto {

    private Integer codclientes;
    private String dnicli;
    private String nombrecli;
    private String apellidocli;
    private String celularcli;
    private String correocli;
    private Integer edadcli;
    private String sexocli;
    private String direccioncli;
}
