package pe.edu.idat.licoreria_continua2.service;

import pe.edu.idat.licoreria_continua2.model.bd.Categoria;
import pe.edu.idat.licoreria_continua2.model.dto.CategoriaDto;

import java.util.List;

public interface ICategoriaService {

    List<CategoriaDto> listarCategorias();

    void  guardarCategoria(CategoriaDto categoria);


}
