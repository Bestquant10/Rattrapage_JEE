package modele;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="t_categorie")
public class Categorie implements Serializable
{
	private  static  final  long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name="categorie_nom")
	private String nom;
	
	@ManyToMany(mappedBy = "categories")
	private List<Ressource> ressources;
}
