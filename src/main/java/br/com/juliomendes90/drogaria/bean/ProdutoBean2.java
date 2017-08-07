package br.com.juliomendes90.drogaria.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.juliomendes90.drogaria.domain.Produto;

@ManagedBean
@ViewScoped
public class ProdutoBean2 implements Serializable {
	
	private static final long serialVersionUID = -330605905775401158L;
	
	private Produto produto;
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	@PostConstruct
	public void novo() {
		produto = new Produto();
	}
}