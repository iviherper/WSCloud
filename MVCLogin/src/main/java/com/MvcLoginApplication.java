package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.modelo.entidad.Usuario;
import com.modelo.persistencia.DaoUsuario;

@SpringBootApplication
public class MvcLoginApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MvcLoginApplication.class, args);
		DaoUsuario dao = context.getBean("daoUsuario", DaoUsuario.class);
		
		Usuario u = new Usuario();
		u.setUsername("goku");
		u.setPassword("123456");
		
		dao.save(u);
	}

}
