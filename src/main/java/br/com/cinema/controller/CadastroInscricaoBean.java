package br.com.cinema.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import br.com.cinema.model.Cidade;
import br.com.cinema.model.Estado;
import br.com.cinema.model.Inscricao;
import br.com.cinema.repository.CidadeRepository;
import br.com.cinema.repository.EstadoRepository;
import br.com.cinema.repository.InscricaoRepository;
import br.com.cinema.util.JsfUtil;

@Named
@ViewScoped
public class CadastroInscricaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private InscricaoRepository inscricaoRepository;

	@Inject
	private EstadoRepository estadoRepository;

	@Inject
	private CidadeRepository cidadeRepository;

	private Inscricao inscricao;
	private Estado estado;

	private List<Estado> listaEstados;
	private List<Cidade> listaCidades;

	public CadastroInscricaoBean() {
		limpar();
	}

	public void inicializar(String ref) throws IOException {
		if (JsfUtil.isNotPostback()) {
			listaEstados = estadoRepository.estados();
		}
	}

	private void limpar() {
		inscricao = new Inscricao();
		estado = null;
		listaCidades = new ArrayList<>();
	}

	public void carregarCidades() {
		listaCidades = null;
		listaCidades = cidadeRepository.cidadesDoEstado(estado);
	}

	public void salvar() {

		this.inscricao.setEstado(estado);
		this.inscricaoRepository.guardar(this.inscricao);

		limpar();

		JsfUtil.addInfoMessage("A inscrição foi realizada com sucesso!");
	}

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}

	@NotNull
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getListaEstados() {
		return listaEstados;
	}

	public List<Cidade> getListaCidades() {
		return listaCidades;
	}

}
