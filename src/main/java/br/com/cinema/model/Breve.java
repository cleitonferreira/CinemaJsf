package br.com.cinema.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "BREVE")
public class Breve implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "BREVE_ID", nullable = false)
	private Integer breve_id;
	@NotBlank
	@Column(name = "BREVE_NOME", nullable = true, length = 40)
	private String breve_nome;
	@Column(name = "BREVE_DURACAO", nullable = true, length = 20)
	private String breve_duracao;
	@Column(name = "BREVE_ELENCO", nullable = true, length = 40)
	private String breve_elenco;
	@Column(name = "BREVE_IDIOMA", nullable = true, length = 20)
	private String breve_idioma;
	@Column(name = "BREVE_CLASSIFICACAO", nullable = true, length = 20)
	private String breve_classificacao;
	@Column(name = "BREVE_TRAILER", nullable = true, length = 40)
	private String breve_trailer;
	@Column(name = "BREVE_DESCRICAO", nullable = true, columnDefinition = "Text")
	private String breve_descricao;
	@NotNull
	@Column(name = "BREVE_DATAINICIO", nullable = true)
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date breve_datainicio;
	@NotNull
	@Column(name = "BREVE_DATAFIM", nullable = true)
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date breve_datafim;
	@Column(name = "BREVE_STATUS", nullable = true, columnDefinition = "TINYINT(1)")
	private boolean breve_status;
	@Basic(optional = true)
	@Column(name = "BREVE_DATACAD", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date breve_datacad;
	
	@ManyToOne(optional = false)
	@ForeignKey(name = "FK_GENERO_BREVE")
	@JoinColumn(name = "GENERO_ID", referencedColumnName = "genero_id", nullable = true)
	@NotNull
	private Genero genero;
	
	
	
	public Breve(){
		this.genero = new Genero();
	}

	public Integer getBreve_id() {
		return breve_id;
	}

	public void setBreve_id(Integer breve_id) {
		this.breve_id = breve_id;
	}

	public String getBreve_nome() {
		return breve_nome;
	}

	public void setBreve_nome(String breve_nome) {
		this.breve_nome = breve_nome;
	}

	public String getBreve_duracao() {
		return breve_duracao;
	}

	public void setBreve_duracao(String breve_duracao) {
		this.breve_duracao = breve_duracao;
	}

	public String getBreve_elenco() {
		return breve_elenco;
	}

	public void setBreve_elenco(String breve_elenco) {
		this.breve_elenco = breve_elenco;
	}

	public String getBreve_idioma() {
		return breve_idioma;
	}

	public void setBreve_idioma(String breve_idioma) {
		this.breve_idioma = breve_idioma;
	}

	public String getBreve_classificacao() {
		return breve_classificacao;
	}

	public void setBreve_classificacao(String breve_classificacao) {
		this.breve_classificacao = breve_classificacao;
	}

	public String getBreve_trailer() {
		return breve_trailer;
	}

	public void setBreve_trailer(String breve_trailer) {
		this.breve_trailer = breve_trailer;
	}

	public String getBreve_descricao() {
		return breve_descricao;
	}

	public void setBreve_descricao(String breve_descricao) {
		this.breve_descricao = breve_descricao;
	}

	public Date getBreve_datainicio() {
		return breve_datainicio;
	}

	public void setBreve_datainicio(Date breve_datainicio) {
		this.breve_datainicio = breve_datainicio;
	}

	public Date getBreve_datafim() {
		return breve_datafim;
	}

	public void setBreve_datafim(Date breve_datafim) {
		this.breve_datafim = breve_datafim;
	}

	public boolean isBreve_status() {
		return breve_status;
	}

	public void setBreve_status(boolean breve_status) {
		this.breve_status = breve_status;
	}

	public Date getBreve_datacad() {
		return breve_datacad;
	}

	public void setBreve_datacad(Date breve_datacad) {
		this.breve_datacad = breve_datacad;
	}
	
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((breve_id == null) ? 0 : breve_id.hashCode());
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
		Breve other = (Breve) obj;
		if (breve_id == null) {
			if (other.breve_id != null)
				return false;
		} else if (!breve_id.equals(other.breve_id))
			return false;
		return true;
	}

	
	
	
	
	
	
	

}
