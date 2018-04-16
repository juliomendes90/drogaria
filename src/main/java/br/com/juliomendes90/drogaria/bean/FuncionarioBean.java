package br.com.juliomendes90.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.juliomendes90.drogaria.dao.FuncionarioDAO;
import br.com.juliomendes90.drogaria.dao.PessoaDAO;
import br.com.juliomendes90.drogaria.domain.Funcionario;
import br.com.juliomendes90.drogaria.domain.Pessoa;

@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable {

	private static final long serialVersionUID = -6548393438607002311L;

	private Funcionario funcionario;
	
	private List<Funcionario> funcionarios;
	
	private List<Pessoa> pessoas;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	@PostConstruct
	public void listar() {
		
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarios = funcionarioDAO.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os funcionarios");
			e.printStackTrace();
		}
	}
	
	public void novo() {
		try {
			funcionario = new Funcionario();

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar criar um novo funcionario");
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.merge(funcionario);

			funcionario = new Funcionario();
			
			funcionarios = funcionarioDAO.listar();

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar("nome");
			
			Messages.addGlobalInfo("Funcionario salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o funcionario");
			erro.printStackTrace();
		}
	}
}