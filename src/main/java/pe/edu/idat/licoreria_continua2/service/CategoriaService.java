package pe.edu.idat.licoreria_continua2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.licoreria_continua2.model.bd.Categoria;
import pe.edu.idat.licoreria_continua2.model.bd.Producto;
import pe.edu.idat.licoreria_continua2.model.bd.Proveedor;
import pe.edu.idat.licoreria_continua2.model.dto.CategoriaDto;
import pe.edu.idat.licoreria_continua2.model.dto.ProductoDto;
import pe.edu.idat.licoreria_continua2.repository.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService implements ICategoriaService{

    private CategoriaRepository categoriaRepository;
    @Override
    public List<CategoriaDto> listarCategorias() {
        List<CategoriaDto>categoriaDtoList = new ArrayList<>();
        for (Categoria cate : categoriaRepository.findAll()){
            CategoriaDto categoriaDto =CategoriaDto.builder().codcategoria(cate.getCodcategoria())
                    .nombrecategoria(cate.getNombrecategoria())
                    .build();
            categoriaDtoList.add(categoriaDto);

        }
        return categoriaDtoList;
    }

    @Override
    public void guardarCategoria(CategoriaDto categoria) {

        if( categoria.getCodcategoria() >0){
            categoriaRepository.actualizarCategoria(
                    categoria.getCodcategoria(),
                    categoria.getNombrecategoria());
        }else{
            Categoria nuevoCategoria = new Categoria();
            nuevoCategoria.setNombrecategoria(categoria.getNombrecategoria());

            categoriaRepository.save(nuevoCategoria);

        }
    }
}
