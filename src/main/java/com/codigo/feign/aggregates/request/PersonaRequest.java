package com.codigo.feign.aggregates.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaRequest {
    //lo que vamos a enviar en el body
    private String tipoDoc;
    private String numDoc;
}
