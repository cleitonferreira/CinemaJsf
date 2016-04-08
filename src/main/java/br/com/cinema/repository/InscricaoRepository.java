package br.com.cinema.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.cinema.model.Inscricao;
import br.com.cinema.repository.filter.InscricaoFilter;

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


    public void remover(Inscricao inscricao) {
	try {
		manager.getTransaction().begin();
		inscricao = porId(inscricao.getInscricao_id());
	    manager.remove(inscricao);
	    manager.flush();
	} catch (PersistenceException e) {
	    System.out.println("Inscrição não pode ser excluída");
	}
    }

	@SuppressWarnings("unchecked")
	public List<Inscricao> filtrados(InscricaoFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Inscricao.class);

		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("inscricao_nome", filtro.getNome(),
					MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotBlank(filtro.getCpf())) {
			criteria.add(Restrictions.ilike("inscricao_cpf", filtro.getCpf(),
					MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("inscricao_nome")).list();
	}
}