package com.monet.domain.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SchemaGenerate {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("DBPostgres");
		EntityManager manager = factory.createEntityManager();
		List<Curso> cursos = manager.createQuery("from Curso", Curso.class).getResultList();
		System.out.println("fsffs");
		System.out.println(cursos);
		
		manager.close();
		factory.close();
	}
	
}
