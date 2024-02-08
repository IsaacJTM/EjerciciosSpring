package com.example.ResapoSpring.Repository;

import com.example.ResapoSpring.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, String> {

}
