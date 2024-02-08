package com.example.ResapoSpring.Repository;

import com.example.ResapoSpring.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
