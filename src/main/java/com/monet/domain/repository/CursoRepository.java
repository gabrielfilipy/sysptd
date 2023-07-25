package com.monet.domain.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.monet.domain.model.Curso;

public class CursoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public CursoRepository() { }

	public CursoRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Curso searchForId(Long id) {
		return manager.find(Curso.class, id);
	}

	public List<Curso> searchForTitle(String titulo){
		TypedQuery<Curso> query = manager.createQuery("from Curso where titulo like :titulo", Curso.class);
		query.setParameter("titulo", titulo + "%");
		return query.getResultList();
	}

	public List<Curso> findAll(){
		return manager.createQuery("FROM Curso", Curso.class).getResultList();
	}

	public Curso save(Curso curso) {
		return manager.merge(curso);
	}

	public void delete(Curso curso) {
		curso = searchForId(curso.getCurso_id());
		manager.remove(curso);
	}

	public List<Curso> searchForColletion(String titulo) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		CriteriaQuery<Curso> criteriaQuery = criteriaBuilder.createQuery(Curso.class);		
		Root<Curso> root = criteriaQuery.from(Curso.class);			
		criteriaQuery.select(root);				
		criteriaQuery.where(criteriaBuilder.like(root.get("titulo"), titulo + "%"));		
		
		TypedQuery<Curso> query = manager.createQuery(criteriaQuery);
		
		return query.getResultList();
	}
	
}
