package com.monet.domain.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.monet.domain.model.Curso;
import com.monet.domain.repository.CursoRepository;
import com.monet.domain.util.Transacional;
 
public class CursoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CursoRepository cursoRepository;
	
	@Transacional
	public void save(Curso curso) {
		cursoRepository.save(curso);
	}
	
	@Transacional
	public void delete(Curso curso) {
		cursoRepository.delete(curso);
	}
	
}
