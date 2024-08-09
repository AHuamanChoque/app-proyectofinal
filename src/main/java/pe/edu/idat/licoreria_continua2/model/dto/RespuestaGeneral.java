package pe.edu.idat.licoreria_continua2.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespuestaGeneral {
    private boolean resultado;
    private String mensaje;
}
