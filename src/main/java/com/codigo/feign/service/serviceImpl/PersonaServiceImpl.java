package com.codigo.feign.service.serviceImpl;


import com.codigo.feign.aggregates.request.PersonaRequest;
import com.codigo.feign.aggregates.response.BaseResponse;
import com.codigo.feign.feignClient.ReniecClient;
import com.codigo.feign.repository.PersonaRepository;
import com.codigo.feign.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private  PersonaRepository personaRepository;

    @Autowired
    private  ReniecClient reniecClient;


    /*
    public PersonaServiceImpl(PersonaRepository personaRepository, ReniecClient reniecClient){
        this.personaRepository = personaRepository;
        this.reniecClient = reniecClient;
    }
    */

    @Override
    public BaseResponse createPerson(PersonaRequest personaRequest) {
        return null;
    }

    @Override
    public BaseResponse getInfoReniec(String numero) {
        return null;
    }
}
