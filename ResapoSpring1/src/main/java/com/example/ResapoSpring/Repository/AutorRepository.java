package com.example.ResapoSpring.Repository;

import com.example.ResapoSpring.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor,Integer> {
    Optional<Autor> findByNombre(String nombre);
}
