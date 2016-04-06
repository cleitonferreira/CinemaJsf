/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cinema.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author cleiton
 */
@Entity
@Table(name = "ESTADO")
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "EST_ID", nullable = false)
    private Integer est_id;
    @Column(name = "EST_NOME", nullable = false, length = 80)
    private String est_nome;
    @Column(name = "EST_UF", nullable = false, columnDefinition = "CHAR(3)")
    private String est_uf;

    //relacionamentos
    @ManyToOne(optional = false)
    @ForeignKey(name = "FK_PAIS_ESTADO")
    @JoinColumn(name = "PA_ID", referencedColumnName = "pa_id")
    private Pais pais;

    @OneToMany(mappedBy = "estado")
    @ForeignKey(name = "FK_ESTADO_CIDADE")
    private List<Cidade> cidades;

    @OneToMany(mappedBy = "estado")
    @ForeignKey(name = "FK_ESTADO_INSCRICAO")
    private List<Inscricao> inscricoes;
    
//    @OneToMany(mappedBy = "estado")
//    @ForeignKey(name = "FK_ESTADO_LOCAL_PROVA")
//    private List<Local_Prova> local_Provas;
    
    
    

    public Estado() {
        this.pais = new Pais();
    }



	public Integer getEst_id() {
		return est_id;
	}

	public void setEst_id(Integer est_id) {
		this.est_id = est_id;
	}

	public String getEst_nome() {
		return est_nome;
	}

	public void setEst_nome(String est_nome) {
		this.est_nome = est_nome;
	}

	public String getEst_uf() {
		return est_uf;
	}

	public void setEst_uf(String est_uf) {
		this.est_uf = est_uf;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	public List<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}

//	public List<Local_Prova> getLocal_Provas() {
//		return local_Provas;
//	}
//
//	public void setLocal_Provas(List<Local_Prova> local_Provas) {
//		this.local_Provas = local_Provas;
//	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((est_id == null) ? 0 : est_id.hashCode());
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
		Estado other = (Estado) obj;
		if (est_id == null) {
			if (other.est_id != null)
				return false;
		} else if (!est_id.equals(other.est_id))
			return false;
		return true;
	}

    
    
}
