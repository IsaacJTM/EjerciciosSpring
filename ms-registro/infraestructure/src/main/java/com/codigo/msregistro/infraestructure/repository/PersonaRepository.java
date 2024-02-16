package com.codigo.msregistro.infraestructure.repository;

import com.codigo.msregistro.infraestructure.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long>{

    Optional<PersonaEntity> findByNumDoc(String NumDoc);
}
