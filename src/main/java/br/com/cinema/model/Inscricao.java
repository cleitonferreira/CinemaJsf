/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cinema.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author cleiton
 */
@Entity
@Table(name = "INSCRICAO")
public class Inscricao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name = "INSCRICAO_ID", nullable = false)
	private Integer inscricao_id;
	@NotBlank
	@Size(min = 4, message = "completo")
	@Column(name = "INSCRICAO_NOME", nullable = true, length = 40)
	private String inscricao_nome;
	@Column(name = "INSCRICAO_NOME_MAE", nullable = true, length = 40)
	private String inscricao_nome_mae;
	@Column(name = "INSCRICAO_NOME_PAI", nullable = true, length = 40)
	private String inscricao_nome_pai;
	@Column(name = "INSCRICAO_CPF", nullable = false, length = 14)
	// 224.491.491-71
	private String inscricao_cpf;
	@NotBlank
	@Column(name = "INSCRICAO_RG", nullable = true, length = 20)
	private String inscricao_rg;
	@NotBlank
	@Column(name = "INSCRICAO_OE", nullable = true, length = 30)
	private String inscricao_oe;
	@NotNull
	@Column(name = "INSCRICAO_DATANASC", nullable = true)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date inscricao_datanasc;
	@Column(name = "INSCRICAO_SEXO", nullable = true, columnDefinition = "TINYINT(1)")
	private boolean inscricao_sexo;
	@Column(name = "INSCRICAO_NATURALIDADE", nullable = true, length = 40)
	private String inscricao_naturalidade;
	@Column(name = "INSCRICAO_ENDERECO", nullable = true, length = 40)
	private String inscricao_endereco;
	@Column(name = "INSCRICAO_NUMERO", nullable = true, length = 10)
	private String inscricao_numero;
	@Column(name = "INSCRICAO_BAIRRO", nullable = true, length = 40)
	private String inscricao_bairro;
	@Column(name = "INSCRICAO_CEP", nullable = true, length = 10)
	// 27600-000
	private String inscricao_cep;
	@Column(name = "INSCRICAO_TEL", nullable = true, length = 14)
	// (34)-8888-8888
	private String inscricao_tel;
	@Column(name = "INSCRICAO_CEL", nullable = true, length = 15)
	// (34)-88888-8888
	private String inscricao_cel;
	@NotBlank
	@Column(name = "INSCRICAO_EMAIL", nullable = true, length = 40)
	private String inscricao_email;
	@Column(name = "INSCRICAO_SENHA", nullable = true, length = 40)
	private String inscricao_senha;
	@Column(name = "INSCRICAO_PORTADOR_ESPECIAL", nullable = true, columnDefinition = "TINYINT(1)")
	private boolean inscricao_portador_especial;
	@Column(name = "INSCRICAO_PORTADOR_DESCRICAO", nullable = true, length = 100)
	private String inscricao_portador_descricao;
	@Column(name = "INSCRICAO_ESCOLA", nullable = true, length = 40)
	private String inscricao_escola;
	@Column(name = "INSCRICAO_STATUS", nullable = true, columnDefinition = "TINYINT(1)")
	private boolean inscricao_status;
	@Basic(optional = true)
	// funcionando
	// @Column(name = "INSCRICAO_DATACAD", insertable = false, updatable =
	// false)
	// @Temporal(TemporalType.TIMESTAMP)
	// private Date inscricao_datacad;
	@Column(name = "INSCRICAO_DATACAD", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date inscricao_datacad;



	// //////////////////////////////////////////////////////////
	// RELACIONAMENTOS
	
	@ManyToOne(optional = false)
	@ForeignKey(name = "FK_ESTADO_INSCRICAO")
	@JoinColumn(name = "EST_ID", referencedColumnName = "est_id", nullable = true)
	private Estado estado;

	@ManyToOne(optional = false)
	@ForeignKey(name = "FK_CIDADE_INSCRICAO")
	@JoinColumn(name = "CID_ID", referencedColumnName = "cid_id", nullable = true)
	@NotNull
	private Cidade cidade;
	
	@OneToMany(mappedBy = "inscricao")
	@ForeignKey(name = "FK_INSCRICAO_INSCRICAO_FILME")
	private List<Inscricao_Filme> inscricao_filmes;
	
	
	

	public Inscricao() {
		this.estado = new Estado();
		this.cidade = new Cidade();
	}
	
	
	
	



	public Integer getInscricao_id() {
		return inscricao_id;
	}

	public void setInscricao_id(Integer inscricao_id) {
		this.inscricao_id = inscricao_id;
	}

	public String getInscricao_nome() {
		return inscricao_nome;
	}

	public void setInscricao_nome(String inscricao_nome) {
		this.inscricao_nome = inscricao_nome;
	}

	public String getInscricao_nome_mae() {
		return inscricao_nome_mae;
	}

	public void setInscricao_nome_mae(String inscricao_nome_mae) {
		this.inscricao_nome_mae = inscricao_nome_mae;
	}

	public String getInscricao_nome_pai() {
		return inscricao_nome_pai;
	}

	public void setInscricao_nome_pai(String inscricao_nome_pai) {
		this.inscricao_nome_pai = inscricao_nome_pai;
	}

	public String getInscricao_cpf() {
		return inscricao_cpf;
	}

	public void setInscricao_cpf(String inscricao_cpf) {
		this.inscricao_cpf = inscricao_cpf;
	}

	public String getInscricao_rg() {
		return inscricao_rg;
	}

	public void setInscricao_rg(String inscricao_rg) {
		this.inscricao_rg = inscricao_rg;
	}

	public String getInscricao_oe() {
		return inscricao_oe;
	}

	public void setInscricao_oe(String inscricao_oe) {
		this.inscricao_oe = inscricao_oe;
	}

	public Date getInscricao_datanasc() {
		return inscricao_datanasc;
	}

	public void setInscricao_datanasc(Date inscricao_datanasc) {
		this.inscricao_datanasc = inscricao_datanasc;
	}

	public boolean isInscricao_sexo() {
		return inscricao_sexo;
	}

	public void setInscricao_sexo(boolean inscricao_sexo) {
		this.inscricao_sexo = inscricao_sexo;
	}

	public String getInscricao_naturalidade() {
		return inscricao_naturalidade;
	}

	public void setInscricao_naturalidade(String inscricao_naturalidade) {
		this.inscricao_naturalidade = inscricao_naturalidade;
	}

	public String getInscricao_endereco() {
		return inscricao_endereco;
	}

	public void setInscricao_endereco(String inscricao_endereco) {
		this.inscricao_endereco = inscricao_endereco;
	}

	public String getInscricao_numero() {
		return inscricao_numero;
	}

	public void setInscricao_numero(String inscricao_numero) {
		this.inscricao_numero = inscricao_numero;
	}

	public String getInscricao_bairro() {
		return inscricao_bairro;
	}

	public void setInscricao_bairro(String inscricao_bairro) {
		this.inscricao_bairro = inscricao_bairro;
	}

	public String getInscricao_cep() {
		return inscricao_cep;
	}

	public void setInscricao_cep(String inscricao_cep) {
		this.inscricao_cep = inscricao_cep;
	}

	public String getInscricao_tel() {
		return inscricao_tel;
	}

	public void setInscricao_tel(String inscricao_tel) {
		this.inscricao_tel = inscricao_tel;
	}

	public String getInscricao_cel() {
		return inscricao_cel;
	}

	public void setInscricao_cel(String inscricao_cel) {
		this.inscricao_cel = inscricao_cel;
	}

	public String getInscricao_email() {
		return inscricao_email;
	}

	public void setInscricao_email(String inscricao_email) {
		this.inscricao_email = inscricao_email;
	}

	public String getInscricao_senha() {
		return inscricao_senha;
	}

	public void setInscricao_senha(String inscricao_senha) {
		this.inscricao_senha = inscricao_senha;
	}

	public boolean isInscricao_portador_especial() {
		return inscricao_portador_especial;
	}

	public void setInscricao_portador_especial(
			boolean inscricao_portador_especial) {
		this.inscricao_portador_especial = inscricao_portador_especial;
	}

	public String getInscricao_portador_descricao() {
		return inscricao_portador_descricao;
	}

	public void setInscricao_portador_descricao(
			String inscricao_portador_descricao) {
		this.inscricao_portador_descricao = inscricao_portador_descricao;
	}

	public String getInscricao_escola() {
		return inscricao_escola;
	}

	public void setInscricao_escola(String inscricao_escola) {
		this.inscricao_escola = inscricao_escola;
	}

	public boolean isInscricao_status() {
		return inscricao_status;
	}

	public void setInscricao_status(boolean inscricao_status) {
		this.inscricao_status = inscricao_status;
	}

	public Date getInscricao_datacad() {
		return inscricao_datacad;
	}

	public void setInscricao_datacad(Date inscricao_datacad) {
		this.inscricao_datacad = inscricao_datacad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Inscricao_Filme> getInscricao_filmes() {
		return inscricao_filmes;
	}

	public void setInscricao_filmes(List<Inscricao_Filme> inscricao_filmes) {
		this.inscricao_filmes = inscricao_filmes;
	}



	
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((inscricao_id == null) ? 0 : inscricao_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inscricao other = (Inscricao) obj;
		if (inscricao_id == null) {
			if (other.inscricao_id != null)
				return false;
		} else if (!inscricao_id.equals(other.inscricao_id))
			return false;
		return true;
	}

	
	
	
	@Transient
	// habilitar e desabilitar o campo portadorDescrição
	public boolean isHabilitarCampoPortadorDescricao() {
		return inscricao_portador_especial ? false : true;
	}

}