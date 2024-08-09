package pe.edu.idat.licoreria_continua2.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CargoDto {

    private Integer codcargo;
    private String nombrecargo;
}
