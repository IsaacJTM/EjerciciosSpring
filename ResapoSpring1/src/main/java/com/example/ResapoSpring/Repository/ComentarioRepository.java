package com.example.ResapoSpring.Repository;

import com.example.ResapoSpring.Model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario,Integer> {
}
