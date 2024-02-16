package com.codigo.msregistro.domain.ports.out;

import com.codigo.msregistro.domain.aggregates.dto.EmpresaDTO;
import com.codigo.msregistro.domain.aggregates.request.RequestEmpresa;


import java.util.List;
import java.util.Optional;

public interface EmpresaServiceOut {

    EmpresaDTO createEmpresaOut(RequestEmpresa requestEmpresa);
    Optional<EmpresaDTO> obtenerEmpresaOut(Long id);
    List<EmpresaDTO> obtenerTodosEmpresaOut();
    EmpresaDTO actualizarEmpresaOut(Long id, RequestEmpresa requestEmpresa);

    EmpresaDTO deleteEmpresaOut(Long id);
}
