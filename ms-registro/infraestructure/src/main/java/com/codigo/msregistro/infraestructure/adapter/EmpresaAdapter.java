package com.codigo.msregistro.infraestructure.adapter;

import com.codigo.msregistro.domain.aggregates.constants.Constants;
import com.codigo.msregistro.domain.aggregates.dto.EmpresaDTO;
import com.codigo.msregistro.domain.aggregates.request.RequestEmpresa;
import com.codigo.msregistro.domain.aggregates.response.ResponseSunat;
import com.codigo.msregistro.domain.ports.out.EmpresaServiceOut;
import com.codigo.msregistro.infraestructure.entity.EmpresaEntity;
import com.codigo.msregistro.infraestructure.entity.TipoDocumentoEntity;
import com.codigo.msregistro.infraestructure.mapper.EmpresaMapper;
import com.codigo.msregistro.infraestructure.repository.EmpresaRepository;
import com.codigo.msregistro.infraestructure.repository.TipoDocumentoRepository;
import com.codigo.msregistro.infraestructure.rest.client.ClienteSunat;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaAdapter implements EmpresaServiceOut {
    private final EmpresaRepository empresaRepository;
    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final EmpresaMapper empresaMapper;
    private final ClienteSunat clienteSunat;

    @Override
    public EmpresaDTO createEmpresaOut(RequestEmpresa requestEmpresa) {
        ResponseSunat datosSunat = getExecutionSunat(requestEmpresa.getNumDoc());
        empresaRepository.save(getEntity(datosSunat,requestEmpresa));

        return empresaMapper.mapToDTO(getEntity(datosSunat,requestEmpresa));
    }

    @Override
    public Optional<EmpresaDTO> obtenerEmpresaOut(Long id) {
        return Optional.ofNullable(empresaMapper.mapToDTO(empresaRepository.findById(id).get()));
    }

    @Override
    public List<EmpresaDTO> obtenerTodosEmpresaOut() {
        List<EmpresaDTO> empresaDTOList = new ArrayList<>();
        List<EmpresaEntity> entities = empresaRepository.findAll();
        for(EmpresaEntity empresa : entities){
            EmpresaDTO empresaDTO = empresaMapper.mapToDTO(empresa);
            empresaDTOList.add(empresaDTO);
        }
        return empresaDTOList;
    }

    @Override
    public EmpresaDTO actualizarEmpresaOut(Long id, RequestEmpresa requestEmpresa) {
        return null;
    }

    @Override
    public EmpresaDTO deleteEmpresaOut(Long id) {
        return null;
    }


    @Value("${token.api}")
    private String tokenApi;

    //Métodos internos

    public ResponseSunat getExecutionSunat(String numDoc) {
        String authorization = "Bearer "+ tokenApi;
        return clienteSunat.getInfoSunat(numDoc,authorization);
    }

    private EmpresaEntity getEntity(ResponseSunat sunat, RequestEmpresa requestEmpresa){
        TipoDocumentoEntity tipoDocumento = tipoDocumentoRepository.findByCodTipo(requestEmpresa.getTipoDoc());
        EmpresaEntity entity = new EmpresaEntity();
        entity.setNumDoc(sunat.getNumeroDocumento());
        entity.setRazonSocial(sunat.getRazonSocial());
        entity.setNombreComercial(sunat.getCondicion());
        entity.setEstado(Constants.STATUS_ACTIVE);
        entity.setUsuaCrea(Constants.AUDIT_ADMIN);
        entity.setDateCreate(getTimestamp());
        entity.setTipoDocumento(tipoDocumento);
        return entity;
    }

    private Timestamp getTimestamp(){
        long currentTime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(currentTime);
        return timestamp;
    }

    private EmpresaEntity getEntityUpdate(ResponseSunat sunat, EmpresaEntity empresaAutualizada){
        empresaAutualizada.setRazonSocial(sunat.getRazonSocial());
        empresaAutualizada.setUsuaModif(Constants.AUDIT_ADMIN);
        empresaAutualizada.setDateModif(getTimestamp());
        return empresaAutualizada;
    }

}
