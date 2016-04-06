package br.com.cinema.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "CATEGORIA")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotBlank
    @Column(name = "CATEGORIA_INFO", nullable = false, length = 20)
    private String categoria_info;
    @NotBlank
    @Column(name = "CATEGORIA_NOME", nullable = true, length = 40)
    private String categoria_nome;
    @NotNull
    @Column(name = "CATEGORIA_STATUS", nullable = true, columnDefinition = "TINYINT(1)")
    private boolean categoria_status;
    @Basic(optional = true)
    @Column(name = "CATEGORIA_DATACAD", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date categoria_datacad;
    
    
    @OneToMany(mappedBy = "categoria")
    @ForeignKey(name = "FK_CATEGORIA_INGRESSO")
    private List<Ingresso> ingressos;

    
	public Categoria() {
	}

	public String getCategoria_info() {
		return categoria_info;
	}

	public void setCategoria_info(String categoria_info) {
		this.categoria_info = categoria_info;
	}

	public String getCategoria_nome() {
		return categoria_nome;
	}

	public void setCategoria_nome(String categoria_nome) {
		this.categoria_nome = categoria_nome;
	}

	public boolean isCategoria_status() {
		return categoria_status;
	}

	public void setCategoria_status(boolean categoria_status) {
		this.categoria_status = categoria_status;
	}

	public Date getCategoria_datacad() {
		return categoria_datacad;
	}

	public void setCategoria_datacad(Date categoria_datacad) {
		this.categoria_datacad = categoria_datacad;
	}
	
	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoria_info == null) ? 0 : categoria_info.hashCode());
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
		Categoria other = (Categoria) obj;
		if (categoria_info == null) {
			if (other.categoria_info != null)
				return false;
		} else if (!categoria_info.equals(other.categoria_info))
			return false;
		return true;
	}
	

	
   
    
}
