package com.monet.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_INDICADOR")
public class Indicador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INDICADOR_ID")
	private Long indicador_id;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "curso_id", nullable = false)
	private Curso curso;
	
	@JsonIgnore
	@OneToMany(mappedBy = "indicador")
	private List<Conhecimento> conhecimentos = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "indicador")
	private List<Habilidade> habilidades = new ArrayList<>();
	 
	@JsonIgnore
	@OneToMany(mappedBy = "indicador") 
	private List<AtitudesValores> atitudesValores = new ArrayList<>();
	
}
