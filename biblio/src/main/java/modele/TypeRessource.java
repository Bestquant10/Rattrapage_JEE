package modele;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@RequestScoped
@Entity
@Table(name="t_type_ressource")
public class TypeRessource implements Serializable
{
	private  static  final  long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="type_ressource_nom")
	private String nom;
	
	@OneToOne(mappedBy = "typeRessource")
	private Ressource ressource;

	public TypeRessource(){}
	
	public TypeRessource(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Ressource getRessource() {
		return ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}
	
	
	
}
