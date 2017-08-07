package br.com.juliomendes90.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Fabricante extends GenericDomain {

	private static final long serialVersionUID = 4101642439579327375L;
	
	@Column(length = 50, nullable = false)
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}