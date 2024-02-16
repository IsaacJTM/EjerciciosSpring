package com.codigo.msregistro.domain.impl;

import com.codigo.msregistro.domain.aggregates.dto.EmpresaDTO;
import com.codigo.msregistro.domain.aggregates.request.RequestEmpresa;
import com.codigo.msregistro.domain.ports.in.EmpresaServiceIn;
import com.codigo.msregistro.domain.ports.out.EmpresaServiceOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaServiceIn {

    public final EmpresaServiceOut empresaServiceOut;

    @Override
    public EmpresaDTO createEmpresaIn(RequestEmpresa requestEmpresa) {
        return empresaServiceOut.createEmpresaOut(requestEmpresa);
    }

    @Override
    public Optional<EmpresaDTO> obtenerEmpresaIn(Long id) {
        return empresaServiceOut.obtenerEmpresaOut(id);
    }

    @Override
    public List<EmpresaDTO> obtenerTodosEmpresaIn() {
        return empresaServiceOut.obtenerTodosEmpresaOut();
    }

    @Override
    public EmpresaDTO actualizarEmpresaIn(Long id, RequestEmpresa requestEmpresa) {
        return empresaServiceOut.actualizarEmpresaOut(id, requestEmpresa);
    }

    @Override
    public EmpresaDTO deleteEmpresaIn(Long id) {
        return empresaServiceOut.deleteEmpresaOut(id);
    }
}
