package com.codigo.msregistro.application.controller;

import com.codigo.msregistro.domain.aggregates.dto.EmpresaDTO;
import com.codigo.msregistro.domain.aggregates.request.RequestEmpresa;
import com.codigo.msregistro.domain.ports.in.EmpresaServiceIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/empresa")
@RequiredArgsConstructor
public class EmpresaController {
    private final EmpresaServiceIn empresaServiceIn;
    @PostMapping
    public ResponseEntity<EmpresaDTO> registrar(@RequestBody RequestEmpresa requestEmpresa){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(empresaServiceIn.createEmpresaIn(requestEmpresa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> obtenerEmpresa(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(empresaServiceIn.obtenerEmpresaIn(id).get());
        //Utilizamos el get porque estamos utilizando el
    }

    @GetMapping()
    public ResponseEntity<List<EmpresaDTO>> obtenerTodos(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(empresaServiceIn.obtenerTodosEmpresaIn());
    }

    @PutMapping("{id}")
    public ResponseEntity<EmpresaDTO> actualizar(@PathVariable Long id, @RequestBody RequestEmpresa requestEmpresa){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(empresaServiceIn.actualizarEmpresaIn(id, requestEmpresa));
    }
}
