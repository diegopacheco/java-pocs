package example.pojos;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "pessoas")
@NamedQueries({
	@NamedQuery(name="pessoa.todas", query="from Pessoa"),
	@NamedQuery(name="pessoa.porId", query="from Pessoa p where p.id = :id")
})
public class Pessoa {
	
	@Id
	private Integer id;
	
	@Basic
	private String nome;
	
	public Pessoa() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "id: " + id + ", nome: " + nome;
	}
	
}
