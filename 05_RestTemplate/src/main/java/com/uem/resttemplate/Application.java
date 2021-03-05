package com.uem.resttemplate;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import com.uem.resttemplate.modelo.entidad.Persona;
import com.uem.resttemplate.modelo.proxy.PersonaProxy;

@EnableDiscoveryClient
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		PersonaProxy pProxy = context.getBean("personaProxy", PersonaProxy.class);
		
		System.out.println("LISTAR");
		System.out.println(pProxy.listar());
		
		System.out.println("OBTENER");
		System.out.println(pProxy.obtener(1));
		
//		System.out.println("ALTA");
//		Persona p2 = new Persona();
//		p2.setNombre("Jaime");
//		p2.setEdad(23);
//		p2.setPeso(85.0);
//		//System.out.println(pProxy.alta(p2));
//		
//		System.out.println("MODIFICAR");
//		p2.setEdad(26);
//		//System.out.println(pProxy.modificar(p2));
//		
//		//pProxy.baja(3);
//		System.out.println(pProxy.listar());
	}

}
