package br.com.cinema.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.cinema.model.Estado;

public class EstadoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Estado porId(Integer id) {
		return manager.find(Estado.class, id);
	}

	public List<Estado> estados() {
		return manager.createQuery("from Estado", 
				Estado.class).getResultList();
	}
	
}
