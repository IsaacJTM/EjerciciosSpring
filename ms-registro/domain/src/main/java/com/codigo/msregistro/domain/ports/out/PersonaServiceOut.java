package com.codigo.msregistro.domain.ports.out;

import com.codigo.msregistro.domain.aggregates.dto.PersonaDTO;
import com.codigo.msregistro.domain.aggregates.request.RequestPersona;

import java.util.List;
import java.util.Optional;

public interface PersonaServiceOut {

    //Va interectuar Base de Datos y también Adaptador (Infraestructura)
    PersonaDTO createPersonaOut(RequestPersona requestPersona);
    Optional<PersonaDTO> obtenerPersonaOut(Long id);
    List<PersonaDTO> obtenerTodosOut();
    PersonaDTO actualizarOut(Long id, RequestPersona requestPersona);

    PersonaDTO deleteOut(Long id);
}
