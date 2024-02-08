package com.example.ResapoSpring.Service;

import com.example.ResapoSpring.Model.Autor;
import com.example.ResapoSpring.Repository.AutorRepository;
import com.example.ResapoSpring.ResponseBase.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    AutorRepository autorRepository;

    public ResponseBase saveAutor(Autor autor){
        //valida la existencia del autor
        Optional<Autor> autorBD = autorRepository.findByNombre(autor.getNombre());
        if(autorBD.isPresent()){
            return new ResponseBase(408,"Autor ya existe", false,Optional.empty());
        }
        Autor autorguardado = autorRepository.save(autor);
        return new ResponseBase(200,"Autor agregado",true, Optional.of(autorguardado));
    }

    public ResponseBase findByid(Integer id){
        Optional<Autor> autorBD = autorRepository.findById(id);
        if(autorBD.isPresent()){
            return new ResponseBase(200,"Autor encontrado",true,Optional.of(autorBD));
        }
        return  new ResponseBase(404,"Autor no existe", false,Optional.empty());
    }

}
