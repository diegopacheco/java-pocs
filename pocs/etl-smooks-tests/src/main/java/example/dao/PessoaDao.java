package example.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.milyn.scribe.annotation.Dao;
import org.milyn.scribe.annotation.Lookup;
import org.milyn.scribe.annotation.Param;

import example.pojos.Pessoa;

@Dao
public class PessoaDao {

	private final EntityManager em;

	public PessoaDao(EntityManager em) {
		this.em = em;
	}

	@Lookup(name = "id")
	public Pessoa procurarPorId(@Param("id") int id) {
		return em.find(Pessoa.class, id);
	}	
	
	@Lookup()
	@SuppressWarnings("unchecked")
	public List<Pessoa> procurarTodas() {
		return em.createNamedQuery("pessoa.todas").getResultList();
	}

}
