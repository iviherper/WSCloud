package com.uem.restpersona.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uem.restpersona.modelo.entidad.Persona;

@Repository
public interface DaoPersona extends JpaRepository<Persona, Integer>{

}
