package br.com.cinema.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.cinema.model.Cidade;
import br.com.cinema.model.Estado;

public class CidadeRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Cidade porId(Integer id) {
		return manager.find(Cidade.class, id);
	}
	
	public List<Cidade> cidades() {
		return manager.createQuery("from Cidade", 
				Cidade.class).getResultList();
	}
	
	public List<Cidade> cidadesDoEstado(Estado estado) {
		return manager.createQuery("from Cidade where estado = :estado", 
				Cidade.class).setParameter("estado", estado).getResultList();
	}

}
