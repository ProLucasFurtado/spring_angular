package spring.angular.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Modelo que representa a tabela de acesso do banco de dados
 * @author Lucas Furtado
 *
 */
@Entity
public class Acesso  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
