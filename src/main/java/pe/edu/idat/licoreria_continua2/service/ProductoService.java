package pe.edu.idat.licoreria_continua2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.licoreria_continua2.model.bd.Categoria;
import pe.edu.idat.licoreria_continua2.model.bd.Producto;
import pe.edu.idat.licoreria_continua2.model.bd.Proveedor;
import pe.edu.idat.licoreria_continua2.model.dto.ProductoDto;
import pe.edu.idat.licoreria_continua2.repository.ProductoRepository;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ProductoService implements IProductoService{

    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDto> listarProductos() {
        List<ProductoDto>productoDtoList = new ArrayList<>();
        for (Producto prod : productoRepository.findAll()){
            ProductoDto productoDto =ProductoDto.builder().codproducto(prod.getCodproducto())
                    .nombreprod(prod.getNombreprod())
                    .precioprod(prod.getPrecioprod())
                    .stockprod(prod.getStockprod())
                    .precioprod(prod.getPrecioprod())
                    .activo(prod.isActivo())
                    .codcategoria(prod.getCategoria().getCodcategoria())
                    .nombrecategoria(prod.getCategoria().getNombrecategoria())
                    .codproveedor(prod.getProveedor().getCodproveedor())
                    .razonsocial(prod.getProveedor().getRazonsocial())
                    .build();
            productoDtoList.add(productoDto);

        }
        return productoDtoList;
    }

    @Override
    public void guardarProducto(ProductoDto product) {
        if( product.getCodproducto() >0){
            productoRepository.actualizarProducto(
                    product.getCodproducto(),
                    product.getNombreprod(),
                    product.getPrecioprod(),
                    product.getCodcategoria(),
                    product.getCodproveedor(),
                    product.isActivo());
        }else{
            Producto nuevoProducto = new Producto();
            nuevoProducto.setNombreprod(product.getNombreprod());
            nuevoProducto.setPrecioprod(product.getPrecioprod());
            nuevoProducto.setActivo(true);

            Categoria categoria= new Categoria();
            categoria.setCodcategoria(product.getCodcategoria());
            nuevoProducto.setCategoria(categoria);

            Proveedor proveedor= new Proveedor();
            proveedor.setCodproveedor(product.getCodproveedor());
            nuevoProducto.setProveedor(proveedor);
            productoRepository.save(nuevoProducto);

        }
    }

    @Override
    public Producto obtenerProducto(Integer idproducto) {
        return productoRepository.findById(idproducto).orElse(null);
    }
}
