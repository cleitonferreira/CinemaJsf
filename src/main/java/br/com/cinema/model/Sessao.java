package br.com.cinema.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "SESSAO")
public class Sessao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "SESSAO_ID", nullable = false)
	private Integer sessao_id;
	@NotBlank
	@Column(name = "SESSAO_NOME", nullable = false, length = 40)
	private String sessao_nome;
	@NotBlank
	@Column(name = "SESSAO_DESCRICAO", nullable = false, length = 100)
	private String sessao_descricao;
	@NotNull
	@Column(name = "SESSAO_STATUS", nullable = true, columnDefinition = "TINYINT(1)")
	private boolean sessao_status;
    @Basic(optional = true)
    @Column(name = "SESSAO_DATACAD", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sessao_datacad;
    
    @OneToMany(mappedBy = "sessao")
    @ForeignKey(name = "FK_SESSAO_FILME")
    private List<Filme> filmes;
    
    @OneToMany(mappedBy = "sessao")
    @ForeignKey(name = "FK_SESSAO_SALA")
    private List<Sala> salas;
	
    
    public Sessao() {

	}


	public Integer getSessao_id() {
		return sessao_id;
	}

	public void setSessao_id(Integer sessao_id) {
		this.sessao_id = sessao_id;
	}

	public String getSessao_nome() {
		return sessao_nome;
	}

	public void setSessao_nome(String sessao_nome) {
		this.sessao_nome = sessao_nome;
	}

	public String getSessao_descricao() {
		return sessao_descricao;
	}

	public void setSessao_descricao(String sessao_descricao) {
		this.sessao_descricao = sessao_descricao;
	}

	public boolean isSessao_status() {
		return sessao_status;
	}

	public void setSessao_status(boolean sessao_status) {
		this.sessao_status = sessao_status;
	}

	public Date getSessao_datacad() {
		return sessao_datacad;
	}

	public void setSessao_datacad(Date sessao_datacad) {
		this.sessao_datacad = sessao_datacad;
	}
	
	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sessao_id == null) ? 0 : sessao_id.hashCode());
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
		Sessao other = (Sessao) obj;
		if (sessao_id == null) {
			if (other.sessao_id != null)
				return false;
		} else if (!sessao_id.equals(other.sessao_id))
			return false;
		return true;
	}
    
    
	
    
    
	
}
