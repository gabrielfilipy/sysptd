package com.monet.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "TBL_CURSO")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CURSO_ID")
	private Long curso_id;
	
	private String titulo;
	private String eixo;
	private String seguimento;
	private String tipoAcao;
	private String cargaMinima;
	private String cargaMaxima; 
	private String unidadeCurricular;
	
	@JsonIgnore
	@OneToMany(mappedBy = "curso")
	private List<Indicador> indicadores = new ArrayList<>();
	
}
