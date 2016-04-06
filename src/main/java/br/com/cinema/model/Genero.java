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

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "GENERO")
public class Genero implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "GENERO_ID", nullable = false)
	private Integer genero_id;
	@NotBlank
	@Column(name = "GENERO_DESCRICAO", nullable = true, length = 40)
	private String genero_descricao;
	@NotBlank
	@Column(name = "GENERO_OBS", nullable = true, length = 100)
	private String genero_obs;
	@Column(name = "GENERO_STATUS", nullable = true, columnDefinition = "TINYINT(1)")
	private boolean genero_status;
	@Basic(optional = true)
	@Column(name = "GENERO_DATACAD", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date genero_datacad;
    
    @OneToMany(mappedBy = "genero")
    @ForeignKey(name = "FK_GENERO_FILME")
    private List<Filme> filmes;
	
    @OneToMany(mappedBy = "genero")
    @ForeignKey(name = "FK_GENERO_BREVE")
    private List<Breve> breves;
    
	public Genero() {

	}

	public Integer getGenero_id() {
		return genero_id;
	}

	public void setGenero_id(Integer genero_id) {
		this.genero_id = genero_id;
	}

	public String getGenero_descricao() {
		return genero_descricao;
	}

	public void setGenero_descricao(String genero_descricao) {
		this.genero_descricao = genero_descricao;
	}

	public String getGenero_obs() {
		return genero_obs;
	}

	public void setGenero_obs(String genero_obs) {
		this.genero_obs = genero_obs;
	}

	public boolean isGenero_status() {
		return genero_status;
	}

	public void setGenero_status(boolean genero_status) {
		this.genero_status = genero_status;
	}

	public Date getGenero_datacad() {
		return genero_datacad;
	}

	public void setGenero_datacad(Date genero_datacad) {
		this.genero_datacad = genero_datacad;
	}

	public List<Breve> getBreves() {
		return breves;
	}

	public void setBreves(List<Breve> breves) {
		this.breves = breves;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}
	
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((genero_id == null) ? 0 : genero_id.hashCode());
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
		Genero other = (Genero) obj;
		if (genero_id == null) {
			if (other.genero_id != null)
				return false;
		} else if (!genero_id.equals(other.genero_id))
			return false;
		return true;
	}
	
	
	
	
	

}
