package pe.edu.idat.licoreria_continua2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.licoreria_continua2.model.bd.Clientes;
import pe.edu.idat.licoreria_continua2.model.bd.Colaborador;
import pe.edu.idat.licoreria_continua2.model.dto.ClientesDto;
import pe.edu.idat.licoreria_continua2.model.dto.ColaboradorDto;
import pe.edu.idat.licoreria_continua2.repository.ColaboradorRepository;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ColaboradorService implements IColaboradorService{

    private ColaboradorRepository colaboradorRepository;
    @Override
    public List<ColaboradorDto> listarColaboradores() {
        List<ColaboradorDto>colaboradorDtoList = new ArrayList<>();
        for (Colaborador col : colaboradorRepository.findAll()){
            ColaboradorDto colaboradorDto =ColaboradorDto.builder().codcolaborador(col.getCodcolaborador())
                    .nombrecol(col.getNombrecol())
                    .apellidocol(col.getApellidocol())
                    .telefonocol(col.getTelefonocol())
                    .correocol(col.getCorreocol())
                    .dnicol(col.getDnicol())
                    .estado(col.getEstado())
                    .codcargo(col.getCargo().getCodcargo())
                    .nombrecargo(col.getCargo().getNombrecargo())
                    .build();
            colaboradorDtoList.add(colaboradorDto);

        }
        return colaboradorDtoList;
    }

    @Override
    public Colaborador guardarColaboradores(Colaborador colaborador) {
        return null;
    }
}
