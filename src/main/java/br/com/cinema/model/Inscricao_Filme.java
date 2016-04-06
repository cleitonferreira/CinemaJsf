package br.com.cinema.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "INSCRICAO_FILME")
public class Inscricao_Filme implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "INSCRICAO_FILME_ID", nullable = true, length = 20, insertable = false, updatable = false)
	private Long inscricao_filme_id;
    @Column(name = "INSCRICAO_FILME_STATUS", nullable = true, columnDefinition = "TINYINT(1)")
    private boolean inscricao_filme_status;
    @Basic(optional = true)
    @Column(name = "INSCRICAO_FILME_DATACAD", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inscricao_filme_datacad;
    
    
    
	// relacionamentos
	@ManyToOne(optional = false)
	@ForeignKey(name = "FK_INGRESSO_INSCRICAO_FILME")
	@JoinColumn(name = "INGRESSO_INFO", referencedColumnName = "ingresso_info", nullable = true)
	@NotNull
	private Ingresso ingresso;
	
	
	
	@ManyToOne(optional = false)
	@ForeignKey(name = "FK_INSCRICAO_INSCRICAO_FILME")
	@JoinColumn(name = "INSCRICAO_ID", referencedColumnName = "inscricao_id", nullable = true)
	@NotNull
	private Inscricao inscricao;
	
	
	
	@ManyToOne(optional = false)
	@ForeignKey(name = "FK_FILME_INSCRICAO_FILME")
	@JoinColumn(name = "FILME_ID", referencedColumnName = "filme_id", nullable = true)
	@NotNull
	private Filme filme;

	
	
	public Inscricao_Filme() {
		this.ingresso = new Ingresso();
		this.inscricao = new Inscricao();
		this.filme = new Filme();
	}



	public Long getInscricao_filme_id() {
		return inscricao_filme_id;
	}

	public void setInscricao_filme_id(Long inscricao_filme_id) {
		this.inscricao_filme_id = inscricao_filme_id;
	}

	public boolean isInscricao_filme_status() {
		return inscricao_filme_status;
	}

	public void setInscricao_filme_status(boolean inscricao_filme_status) {
		this.inscricao_filme_status = inscricao_filme_status;
	}

	public Date getInscricao_filme_datacad() {
		return inscricao_filme_datacad;
	}

	public void setInscricao_filme_datacad(Date inscricao_filme_datacad) {
		this.inscricao_filme_datacad = inscricao_filme_datacad;
	}

	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}


	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((inscricao_filme_id == null) ? 0 : inscricao_filme_id
						.hashCode());
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
		Inscricao_Filme other = (Inscricao_Filme) obj;
		if (inscricao_filme_id == null) {
			if (other.inscricao_filme_id != null)
				return false;
		} else if (!inscricao_filme_id.equals(other.inscricao_filme_id))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
