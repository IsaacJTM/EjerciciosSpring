package com.codigo.feign.service.serviceImpl;

import com.codigo.feign.aggregates.constants.Constants;
import com.codigo.feign.aggregates.request.EmpresaRequest;
import com.codigo.feign.aggregates.response.BaseResponse;
import com.codigo.feign.aggregates.response.ReniecResponse;
import com.codigo.feign.aggregates.response.SunatResponse;
import com.codigo.feign.feignClient.SunatClient;
import com.codigo.feign.repository.EmpresaRepository;
import com.codigo.feign.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private SunatClient sunatClient;

    @Override
    public BaseResponse createEmpresa(EmpresaRequest empresaRequest) {
        return null;
    }

    @Value("${token.api}")
    private String tokenApi;

    @Override
    public BaseResponse getInfoSunat(String numero) {
        SunatResponse respuesta = getEjecucion(numero);
        if(respuesta !=null){
            return new BaseResponse(Constants.CODE_SUCCESS,Constants.MESS_SUCCESS, Optional.of(respuesta));

        }
        return new BaseResponse(Constants.CODE_ERROR,Constants.MESS_ERROR,Optional.empty());
    }

    private SunatResponse getEjecucion(String numero){
        String Authorization = "Bearer " + tokenApi;
        return sunatClient.getInfo(numero, Authorization);
    }
}
