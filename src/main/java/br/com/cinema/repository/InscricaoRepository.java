package br.com.cinema.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.cinema.model.Inscricao;

public class InscricaoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Inscricao guardar(Inscricao inscricao) {
		// controlar transação aqui pode não ser o melhor lugar
		// mas fiz isso apenas para esse exemplo ficar mais simples
		manager.getTransaction().begin();
		inscricao = manager.merge(inscricao);
		manager.getTransaction().commit();

		return inscricao;
	}

	public List<Inscricao> porCpf(String cpf) {
		String query = "from Inscricao where inscricao_cpf = :cpf ";

		return manager.createQuery(query, Inscricao.class)
				.setParameter("cpf", cpf)
				.getResultList();
	}

	public Inscricao porId(Integer id) {
		return manager.find(Inscricao.class, id);
	}
}