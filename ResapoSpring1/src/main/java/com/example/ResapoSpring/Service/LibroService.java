package com.example.ResapoSpring.Service;

import com.example.ResapoSpring.Model.Libro;
import com.example.ResapoSpring.Repository.LibroRepository;
import com.example.ResapoSpring.ResponseBase.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    LibroRepository libroRepository;

    public ResponseBase saveLibro(Libro libro){
        Optional<Libro> libroBD = libroRepository.findById(libro.getIsbn());
        if(libroBD.isPresent()){
            return new ResponseBase(404,"libro ya Existe",false,Optional.empty());
        }
        Libro libroGuardado = libroRepository.save(libro);
        return new ResponseBase(201,"exito", true,Optional.of(libroGuardado));
    }
}
