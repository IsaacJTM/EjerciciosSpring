package com.example.ResapoSpring.Controller;

import com.example.ResapoSpring.Model.Autor;
import com.example.ResapoSpring.ResponseBase.ResponseBase;
import com.example.ResapoSpring.Service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @PostMapping("/save")
    public ResponseBase saveAutor(@RequestBody Autor autor){
        ResponseBase autores = autorService.saveAutor(autor);
        return autores;
    }

    @GetMapping("/buscarId/{id}")
    public ResponseBase findById(@PathVariable Integer id){
        return autorService.findByid(id);
    }
}
