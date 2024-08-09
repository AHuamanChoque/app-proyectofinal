package pe.edu.idat.licoreria_continua2.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductoDto {
    private Integer codproducto;
    private String nombreprod;
    private Double precioprod;
    private Integer stockprod;
    private boolean activo;
    private Integer codcategoria; //tabla categoria
    private String nombrecategoria;//tabla categoria

    private Integer codproveedor;//tabla proveedor
    private String razonsocial;//tabla proveedor
}
