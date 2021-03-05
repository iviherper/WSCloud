package Negocio;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Entidad.Persona;

public class MainSpring {
	
	public static ApplicationContext context = null;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("Recursos/context.xml");
		Persona p1 = (Persona) context.getBean("persona1");
		p1.setNombre("Harry");
		p1.setEdad(19);
		p1.setPeso(58.3);
		Persona p2 = context.getBean("persona2",Persona.class);
		System.out.println(p2.getNombre());
		
		Persona p3 = context.getBean("personaPrototype", Persona.class);
		p3.setNombre("Gandalf");
		p3.setPeso(80);
		
		@SuppressWarnings("unchecked")
		List<Persona> lp = context.getBean("listaPersonas", List.class);
		lp.add(p3);
	
	}
	
	public static void cambiarNombre(Persona p, String nombre) {
		p.setNombre(nombre);
	}
}
