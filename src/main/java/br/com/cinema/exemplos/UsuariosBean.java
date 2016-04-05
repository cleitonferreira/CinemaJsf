package br.com.cinema.exemplos;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "usuarios")
@SessionScoped
public class UsuariosBean {
	private String nome, senha;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public String validarUsuario() {
		if (nome.equals("user") && senha.equals("123")) {
			return "/exemplos/sucesso";
		} else {
			return "/exemplos/erro";
		}
	}
}
