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
@Table(name = "CIDADE")
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "CID_ID", nullable = false)
    private Integer cid_id;
    @Column(name = "CID_NOME", nullable = true, length = 80)
    private String cid_nome;

    //relacionamento com estado
    @ManyToOne(optional = true)
    @ForeignKey(name = "FK_ESTADO_CIDADE")
    @JoinColumn(name = "EST_ID", referencedColumnName = "est_id")
    private Estado estado;

    @OneToMany(mappedBy = "cidade")
    @ForeignKey(name = "FK_CIDADE_INSCICAO")
    private List<Inscricao> inscricoes;
    
//    @OneToMany(mappedBy = "cidade")
//    @ForeignKey(name = "FK_CIDADE_LOCAL_PROVA")
//    private List<Local_Prova> local_Provas;
    

    public Cidade() {
        this.estado = new Estado();
    }

    
    
	public Integer getCid_id() {
		return cid_id;
	}

	public void setCid_id(Integer cid_id) {
		this.cid_id = cid_id;
	}

	public String getCid_nome() {
		return cid_nome;
	}

	public void setCid_nome(String cid_nome) {
		this.cid_nome = cid_nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
		result = prime * result + ((cid_id == null) ? 0 : cid_id.hashCode());
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
		Cidade other = (Cidade) obj;
		if (cid_id == null) {
			if (other.cid_id != null)
				return false;
		} else if (!cid_id.equals(other.cid_id))
			return false;
		return true;
	}

	

 
}
