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
@Table(name = "FILME")
public class Filme implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "FILME_ID", nullable = false)
    private Integer filme_id;
	@NotBlank
	@Column(name = "FILME_NOME", nullable = true, length = 40)
	private String filme_nome;
	@Column(name = "FILME_DURACAO", nullable = true, length = 20)
	private String filme_duracao;
	@Column(name = "FILME_ELENCO", nullable = true, length = 40)
	private String filme_elenco;
	@Column(name = "FILME_IDIOMA", nullable = true, length = 20)
	private String filme_idioma;
	@Column(name = "FILME_CLASSIFICACAO", nullable = true, length = 20)
	private String filme_classificacao;
	@Column(name = "FILME_IMAGEM", nullable = true, length = 40)
	private String filme_imagem;
	@Column(name = "FILME_VISUALIZACAO", nullable = true, length = 5)
	private String filme_visualizacao;
	@Column(name = "FILME_TRAILER", nullable = true, length = 40)
	private String filme_trailer;
	@Column(name = "FILME_DESCRICAO", nullable = true, columnDefinition = "Text")
	private String filme_descricao;
	@NotNull
	@Column(name = "FILME_DATAINICIO", nullable = true)
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date filme_datainicio;
	@NotNull
	@Column(name = "FILME_DATAFIM", nullable = true)
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date filme_datafim;
    @Column(name = "FILME_STATUS", nullable = true, columnDefinition = "TINYINT(1)")
    private boolean filme_status;
    @Basic(optional = true)
    @Column(name = "FILME_DATACAD", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date filme_datacad;
    
	// relacionamentos
	@ManyToOne(optional = false)
	@ForeignKey(name = "FK_GENERO_FILME")
	@JoinColumn(name = "GENERO_ID", referencedColumnName = "genero_id", nullable = true)
	@NotNull
	private Genero genero;
	
	@ManyToOne(optional = false)
	@ForeignKey(name = "FK_SESSAO_FILME")
	@JoinColumn(name = "SESSAO_ID", referencedColumnName = "sessao_id", nullable = true)
	@NotNull
	private Sessao sessao;
	
	@ManyToOne(optional = false)
	@ForeignKey(name = "FK_SALA_FILME")
	@JoinColumn(name = "SALA_ID", referencedColumnName = "sala_id", nullable = true)
	@NotNull
	private Sala sala;
	
	@OneToMany(mappedBy = "filme")
	@ForeignKey(name = "FK_FILME_INSCRICAO_FILME")
	private List<Inscricao_Filme> inscricao_filmes;
	
	

	public Filme() {
		this.genero = new Genero();
		this.sessao = new Sessao();
		this.sala = new Sala();
	}

	public Integer getFilme_id() {
		return filme_id;
	}

	public void setFilme_id(Integer filme_id) {
		this.filme_id = filme_id;
	}

	public String getFilme_nome() {
		return filme_nome;
	}

	public void setFilme_nome(String filme_nome) {
		this.filme_nome = filme_nome;
	}

	public String getFilme_duracao() {
		return filme_duracao;
	}

	public void setFilme_duracao(String filme_duracao) {
		this.filme_duracao = filme_duracao;
	}

	public String getFilme_elenco() {
		return filme_elenco;
	}

	public void setFilme_elenco(String filme_elenco) {
		this.filme_elenco = filme_elenco;
	}

	public String getFilme_idioma() {
		return filme_idioma;
	}

	public void setFilme_idioma(String filme_idioma) {
		this.filme_idioma = filme_idioma;
	}

	public String getFilme_classificacao() {
		return filme_classificacao;
	}

	public void setFilme_classificacao(String filme_classificacao) {
		this.filme_classificacao = filme_classificacao;
	}

	public String getFilme_imagem() {
		return filme_imagem;
	}

	public void setFilme_imagem(String filme_imagem) {
		this.filme_imagem = filme_imagem;
	}

	public String getFilme_visualizacao() {
		return filme_visualizacao;
	}

	public void setFilme_visualizacao(String filme_visualizacao) {
		this.filme_visualizacao = filme_visualizacao;
	}

	public String getFilme_trailer() {
		return filme_trailer;
	}

	public void setFilme_trailer(String filme_trailer) {
		this.filme_trailer = filme_trailer;
	}

	public String getFilme_descricao() {
		return filme_descricao;
	}

	public void setFilme_descricao(String filme_descricao) {
		this.filme_descricao = filme_descricao;
	}

	public Date getFilme_datainicio() {
		return filme_datainicio;
	}

	public void setFilme_datainicio(Date filme_datainicio) {
		this.filme_datainicio = filme_datainicio;
	}

	public Date getFilme_datafim() {
		return filme_datafim;
	}

	public void setFilme_datafim(Date filme_datafim) {
		this.filme_datafim = filme_datafim;
	}

	public boolean isFilme_status() {
		return filme_status;
	}

	public void setFilme_status(boolean filme_status) {
		this.filme_status = filme_status;
	}

	public Date getFilme_datacad() {
		return filme_datacad;
	}

	public void setFilme_datacad(Date filme_datacad) {
		this.filme_datacad = filme_datacad;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
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
				+ ((filme_id == null) ? 0 : filme_id.hashCode());
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
		Filme other = (Filme) obj;
		if (filme_id == null) {
			if (other.filme_id != null)
				return false;
		} else if (!filme_id.equals(other.filme_id))
			return false;
		return true;
	}
	
	
	
	
	
	
}
