package br.com.cinema.consultas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.cinema.model.Categoria;

public class ConsultaCategoria {

    private static EntityManagerFactory factory;

    private EntityManager manager;

    @BeforeClass
    public static void init() {
	factory = Persistence.createEntityManagerFactory("CinemaJsfPU");
    }

    @Before
    public void setUp() {
	this.manager = factory.createEntityManager();
    }

    @After
    public void tearDown() {
	this.manager.close();
    }

    @Test
    public void cache() {
	/*
	 * Utilizando o método “getReference“ você fará um select buscando
	 * apenas o ID do objeto, aliviando o tráfego de dados ao banco de
	 * dados.
	 */
	
	TypedQuery<Categoria> query = this.manager.createQuery("select * from Categoria",
			Categoria.class);
	Categoria categoria = query.getSingleResult();
	
	

	System.out.println();
	System.out.println("Categoria Info: " + categoria.getCategoria_info());
	System.out.println("Catgoria Nome: " + categoria.getCategoria_nome());
	

    }
	
}
