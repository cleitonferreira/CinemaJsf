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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "SALA")
public class Sala implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SALA_ID", nullable = false)
	private Integer sala_id;
	@NotBlank
	@Column(name = "SALA_NOME", nullable = false, length = 40)
	private String sala_nome;
	@NotBlank
	@Column(name = "SALA_DESCRICAO", nullable = false, length = 100)
	private String sala_descricao;
	@NotNull
	@Column(name = "SALA_STATUS", nullable = true, columnDefinition = "TINYINT(1)")
	private boolean sala_status;
	@Basic(optional = true)
	@Column(name = "SALA_DATACAD", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sala_datacad;

	@OneToMany(mappedBy = "sala")
	@ForeignKey(name = "FK_SALA_FILME")
	private List<Filme> filmes;

	@ManyToOne(optional = false)
	@ForeignKey(name = "FK_SESSAO_SALA")
	@JoinColumn(name = "SESSAO_ID", referencedColumnName = "sessao_id", nullable = true)
	@NotNull
	private Sessao sessao;

	
	public Sala() {
		this.sessao = new Sessao();
	}
	
	

	public Integer getSala_id() {
		return sala_id;
	}

	public void setSala_id(Integer sala_id) {
		this.sala_id = sala_id;
	}

	public String getSala_nome() {
		return sala_nome;
	}

	public void setSala_nome(String sala_nome) {
		this.sala_nome = sala_nome;
	}

	public String getSala_descricao() {
		return sala_descricao;
	}

	public void setSala_descricao(String sala_descricao) {
		this.sala_descricao = sala_descricao;
	}

	public boolean isSala_status() {
		return sala_status;
	}

	public void setSala_status(boolean sala_status) {
		this.sala_status = sala_status;
	}

	public Date getSala_datacad() {
		return sala_datacad;
	}

	public void setSala_datacad(Date sala_datacad) {
		this.sala_datacad = sala_datacad;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sala_id == null) ? 0 : sala_id.hashCode());
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
		Sala other = (Sala) obj;
		if (sala_id == null) {
			if (other.sala_id != null)
				return false;
		} else if (!sala_id.equals(other.sala_id))
			return false;
		return true;
	}

	

}
