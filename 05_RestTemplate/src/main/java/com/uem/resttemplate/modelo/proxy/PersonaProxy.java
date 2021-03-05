package com.uem.resttemplate.modelo.proxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uem.resttemplate.modelo.entidad.Persona;

@Service
public class PersonaProxy {
	public static final String URL_PERSONAS = "http://SPRINGRESTCONCESINARIO/personas";
	
	@Autowired
	RestTemplate restTemplate;
	public List<Persona> listar(){
		
		ResponseEntity<Persona[]> response = restTemplate.getForEntity(URL_PERSONAS, Persona[].class);
		List<Persona> personas = Arrays.asList(response.getBody());
		return personas;
	}
	
	public Persona obtener(int id) {
		ResponseEntity<Persona> response = restTemplate.getForEntity(URL_PERSONAS+"/"+id, Persona.class);
		Persona persona = response.getBody();
		return persona;
	}
	
	public Persona alta(Persona persona) {
		HttpEntity<Persona> requestBody = new HttpEntity<Persona>(persona);
		Persona response = restTemplate.postForObject(URL_PERSONAS, requestBody, Persona.class);
		return response;
	}
	
	public Persona modificar(Persona persona) {
		HttpEntity<Persona> requestBody = new HttpEntity<Persona>(persona);
		ResponseEntity<Persona> response = restTemplate.exchange(URL_PERSONAS+"/"+persona.getId(), HttpMethod.PUT, requestBody, Persona.class);
		return response.getBody();
	}
	
	public void baja(int id) {
		restTemplate.delete(URL_PERSONAS+"/"+id);
	}
	
}
