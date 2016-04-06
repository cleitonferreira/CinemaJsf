package br.com.cinema.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "INGRESSO")
public class Ingresso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotBlank
    @Column(name = "INGRESSO_INFO", nullable = false, length = 8)
    private String ingresso_info;
    @NotBlank
    @Column(name = "INGRESSO_DESCRICAO", nullable = false, length = 40)
    private String ingresso_descricao;
    @NotNull
    @Column(name = "INGRESSO_SEQ_ID", nullable = false, length = 20)
    private Long ingresso_seq_id;
    @NotNull
    @Column(name = "INGRESSO_INICIO", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ingresso_inicio;
    @NotNull
    @Column(name = "INGRESSO_VALOR", nullable = true, precision = 10, scale = 2)
    private BigDecimal ingresso_valor;
    @NotNull
    @Column(name = "INGRESSO_FIM", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ingresso_fim;
    @NotNull
    @Column(name = "INGRESSO_DIA", nullable = false, length = 11)
    private Integer ingresso_dia;
    @Basic(optional = true)
    @Column(name = "INGRESSO_DATACAD", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ingresso_datacad;
    
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "FK_CATEGORIA_INGRESSO")
    @JoinColumn(name = "CATEGORIA_INFO", referencedColumnName = "categoria_info", nullable = true)
    @NotNull
    private Categoria categoria;
    

    @OneToMany(mappedBy = "ingresso")
    @ForeignKey(name = "FK_INGRESSO_INSCRICAO_FILME")
    private List<Inscricao_Filme> inscricao_filmes;
    
    
    
	public Ingresso() {
		this.categoria = new Categoria();
	}

	public String getIngresso_info() {
		return ingresso_info;
	}

	public void setIngresso_info(String ingresso_info) {
		this.ingresso_info = ingresso_info;
	}

	public String getIngresso_descricao() {
		return ingresso_descricao;
	}

	public void setIngresso_descricao(String ingresso_descricao) {
		this.ingresso_descricao = ingresso_descricao;
	}

	public Long getIngresso_seq_id() {
		return ingresso_seq_id;
	}

	public void setIngresso_seq_id(Long ingresso_seq_id) {
		this.ingresso_seq_id = ingresso_seq_id;
	}

	public Date getIngresso_inicio() {
		return ingresso_inicio;
	}

	public void setIngresso_inicio(Date ingresso_inicio) {
		this.ingresso_inicio = ingresso_inicio;
	}

	public BigDecimal getIngresso_valor() {
		return ingresso_valor;
	}

	public void setIngresso_valor(BigDecimal ingresso_valor) {
		this.ingresso_valor = ingresso_valor;
	}

	public Date getIngresso_fim() {
		return ingresso_fim;
	}

	public void setIngresso_fim(Date ingresso_fim) {
		this.ingresso_fim = ingresso_fim;
	}

	public Integer getIngresso_dia() {
		return ingresso_dia;
	}

	public void setIngresso_dia(Integer ingresso_dia) {
		this.ingresso_dia = ingresso_dia;
	}

	public Date getIngresso_datacad() {
		return ingresso_datacad;
	}

	public void setIngresso_datacad(Date ingresso_datacad) {
		this.ingresso_datacad = ingresso_datacad;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
				+ ((ingresso_info == null) ? 0 : ingresso_info.hashCode());
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
		Ingresso other = (Ingresso) obj;
		if (ingresso_info == null) {
			if (other.ingresso_info != null)
				return false;
		} else if (!ingresso_info.equals(other.ingresso_info))
			return false;
		return true;
	}


	
}
