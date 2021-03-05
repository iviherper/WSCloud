package com.uem.restpersona.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uem.restpersona.modelo.negocio.GestorPersona;
import com.uem.restpersona.modelo.persistencia.DaoPersona;
import com.uem.restpersona.modelo.entidad.Persona;


@RestController
public class ControladorPersona{
	
	@Autowired
	private GestorPersona gp;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("personas")
	public ResponseEntity<List<Persona>> listar(){
		List<Persona> lista = gp.listar();
		ResponseEntity<List<Persona>> re = new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
		return re;
	}
	
	@GetMapping("personas/{id}")
	public ResponseEntity<Persona> obtener(@PathVariable("id") int id){
		Persona p = gp.obtener(id);
		HttpStatus codigoRespuesta = null;
		if(p != null) {
			String serverPort = environment.getProperty("local.server.port");
			p.setNombre(serverPort+":"+p.getNombre());
			codigoRespuesta = HttpStatus.OK;
		}else {
			codigoRespuesta = HttpStatus.NOT_FOUND;
		}
		ResponseEntity<Persona> re = new ResponseEntity<Persona>(p, codigoRespuesta);
		return re;
		}
	
	@PostMapping("personas")
	public ResponseEntity<Persona> alta(@RequestBody Persona p){
		Persona persona = gp.alta(p);
		HttpStatus status= null;
		if(p != null) {
			status = HttpStatus.CREATED;
		}else {
			status = HttpStatus.BAD_REQUEST;
		}
		ResponseEntity<Persona> re = new ResponseEntity<Persona>(p,status);
		return re;
	}
	
	@PutMapping("personas/{id}")
	public ResponseEntity<Persona> modificar(@RequestBody Persona persona, @PathVariable("id") int id){
		persona.setId(id);
		Persona p = gp.modificar(persona);
		HttpStatus status= null;
		if(p != null) {
			status = HttpStatus.OK;
		}else {
			status = HttpStatus.BAD_REQUEST;
		}
		ResponseEntity<Persona> re = new ResponseEntity<Persona>(p,status);
		return re;
	}
	
	@DeleteMapping("personas/{id}")
	public ResponseEntity<Integer> baja(@PathVariable("id") int id){
		HttpStatus status= null;
		Boolean borrar = gp.baja(id);
		if(borrar) {			
			status = HttpStatus.OK;
		}else {
			status = HttpStatus.BAD_REQUEST;
		}
		ResponseEntity<Integer> re = new ResponseEntity<Integer>(id,status);
		return re;
	}
}
