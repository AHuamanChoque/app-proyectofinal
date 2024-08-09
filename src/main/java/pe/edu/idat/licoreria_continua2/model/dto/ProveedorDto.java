package pe.edu.idat.licoreria_continua2.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProveedorDto {

    private Integer codproveedor;
    private String razonsocial;
    private String rucproveedor;
    private String telefonoproveedor;
    private Integer codtipoprovee;
    private String descripcion;
}
