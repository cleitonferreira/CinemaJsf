package br.com.cinema.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cinema.model.Inscricao;
import br.com.cinema.repository.InscricaoRepository;
import br.com.cinema.repository.filter.InscricaoFilter;
import br.com.cinema.util.JsfUtil;

@Named
@ViewScoped
public class PesquisaInscricaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private InscricaoRepository inscricaoRepository;

	private InscricaoFilter filtro;
	private List<Inscricao> inscricaoFiltrados;

	private Inscricao inscricaoSelecionado;

	public PesquisaInscricaoBean() {
		limpar();
	}

	private void limpar() {
		filtro = new InscricaoFilter();
		inscricaoSelecionado = new Inscricao();
	}

	public void excluir() {
		inscricaoRepository.remover(inscricaoSelecionado);
		inscricaoFiltrados.remove(inscricaoSelecionado);

		JsfUtil.addInfoMessage("Inscrição " + inscricaoSelecionado.getInscricao_nome() + " excluído com sucesso.");
	}

	public void pesquisar() {
		inscricaoFiltrados = inscricaoRepository.filtrados(filtro);
	}

	public List<Inscricao> getInscricaoFiltrados() {
		return inscricaoFiltrados;
	}

	public InscricaoFilter getFiltro() {
		return filtro;
	}

	public Inscricao getInscricaoSelecionado() {
		return inscricaoSelecionado;
	}

	public void setInscricaoSelecionado(Inscricao inscricaoSelecionado) {
		this.inscricaoSelecionado = inscricaoSelecionado;
	}

}
