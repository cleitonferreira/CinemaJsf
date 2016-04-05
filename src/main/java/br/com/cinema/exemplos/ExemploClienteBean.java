package br.com.cinema.exemplos;


import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@Named
@RequestScoped
public class ExemploClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nome;
	private int idade;
	private String cpf;
	private Date dataNascimento;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void imprimirValores(ActionEvent actionEvent) {
		System.out.println("Nome: "+nome);
		System.out.println("Idade: "+idade);
		System.out.println("Cpf: "+cpf);
		System.out.println("Data de nascimento: "+dataNascimento);
		
	}

}
