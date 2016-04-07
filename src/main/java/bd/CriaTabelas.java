package bd;
import javax.persistence.Persistence;

//Precisamos apenas criar um EntityManagerFactory, que todas as tabelas mapeadas
//pelas entidades serão criadas ou atualizadas.

public class CriaTabelas {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("CinemaJsfPU");
	}

}
