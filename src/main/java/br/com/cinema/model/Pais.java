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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author cleiton
 */
@Entity
@Table(name = "PAIS")
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "PA_ID", nullable = false)
    private Integer pa_id;
    @Column(name = "PA_NOME", nullable = false, length = 80)
    private String pa_nome;
    @Column(name = "PA_SIGLA", nullable = false, columnDefinition = "CHAR(3)")
    private String pa_sigla;

    @OneToMany(mappedBy = "pais")
    @ForeignKey(name = "FK_PAIS_ESTADO")
    private List<Estado> estados;

    public Pais() {
    }

    public Integer getPa_id() {
        return pa_id;
    }

    public void setPa_id(Integer pa_id) {
        this.pa_id = pa_id;
    }

    public String getPa_nome() {
        return pa_nome;
    }

    public void setPa_nome(String pa_nome) {
        this.pa_nome = pa_nome;
    }

    public String getPa_sigla() {
        return pa_sigla;
    }

    public void setPa_sigla(String pa_sigla) {
        this.pa_sigla = pa_sigla;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.pa_id != null ? this.pa_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pais other = (Pais) obj;
        if (this.pa_id != other.pa_id && (this.pa_id == null || !this.pa_id.equals(other.pa_id))) {
            return false;
        }
        return true;
    }

    
    
    

}
