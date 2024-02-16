package com.codigo.msregistro.domain.ports.in;

import com.codigo.msregistro.domain.aggregates.dto.EmpresaDTO;
import com.codigo.msregistro.domain.aggregates.request.RequestEmpresa;
import java.util.List;
import java.util.Optional;

public interface EmpresaServiceIn {

    EmpresaDTO createEmpresaIn(RequestEmpresa requestEmpresa);
    Optional<EmpresaDTO> obtenerEmpresaIn(Long id);
    List<EmpresaDTO> obtenerTodosEmpresaIn();
    EmpresaDTO actualizarEmpresaIn(Long id, RequestEmpresa requestEmpresa);

    EmpresaDTO deleteEmpresaIn(Long id);
}
