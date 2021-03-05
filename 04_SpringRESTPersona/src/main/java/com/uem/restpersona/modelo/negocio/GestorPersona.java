package com.uem.restpersona.modelo.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.uem.restpersona.modelo.entidad.Persona;
import com.uem.restpersona.modelo.persistencia.DaoPersona;

@Service
public class GestorPersona {
	@Autowired
	private DaoPersona daoPersona;
	
	public List<Persona> listar(){
		List<Persona> lista = daoPersona.findAll();
		return lista;
	}
	
	public Persona obtener(int id) {
		Optional<Persona> opt = daoPersona.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public Persona alta(Persona p) {
		if(p.getNombre().length()<3) {
			return null;
		}
		Persona persona = daoPersona.save(p);
		return persona;
	}
	
	public Persona modificar(Persona p) {
		if(p.getNombre().length()<3) {
			return null;
		}
		Persona persona = daoPersona.save(p);
		return persona;
	}
	
	public boolean baja(int id) {
		if(daoPersona.findById(id).isPresent()) {
			daoPersona.deleteById(id);
			return true;
		}
		return false;		
	}
}
