package com.monet.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_CONHECIMENTO")
public class Conhecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONHECIMENTO_ID")
	private Long conhecimento_id;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "indicador_id", nullable = false)
	private Indicador indicador;
	
}
