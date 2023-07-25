package com.monet.domain.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.monet.domain.model.Curso;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@ViewScoped
public class CursoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Curso curso;
	
}
