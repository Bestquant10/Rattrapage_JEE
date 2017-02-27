package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Oeuvre")
public class Oeuvre implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name = "oeuvre_id")
	private int id;
	
	@Column(name = "titre_oeuvre")
	private String titreOeuvre;
	
	@Column(name = "forme")
	private String forme;
	
	@Column(name = "date_creation")
	private Date dateCreation;
	
	@OneToMany(mappedBy = "oeuvre")
	private List<Expression> expressions;
	
	@OneToMany(mappedBy = "oeuvre")
	private List<Personne> personnes;
	
	@OneToMany(mappedBy = "oeuvre")
	private List<Collectivite> collectivites;
}
