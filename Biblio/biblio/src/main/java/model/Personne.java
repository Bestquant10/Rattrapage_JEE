package model;

import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "Personne")
public class Personne
{
	
	
	//@Id @GeneratedValue
	//@Column(name = "id")
	private int id;
	
	//@Column(name = "titre")
	private String titre;
	
	//@Column(name = "date_naissance")
	private Date naissance;
	
	//@Column(name = "date_deces")
	private Date deces;
	
	//@Column(name = "date_debut_travail")
	private Date debutTravail;
	
	//@Column(name = "date_fin_travail")
	private Date finTravail;
	
	//@ManyToMany
	//@JoinTable(name ="Oeuvre_Personne", 
	//joinColumns = @JoinColumn(name = "personne_id", referencedColumnName = "personne_id"),
	//inverseJoinColumns = @JoinColumn(name ="oeuvre_id", referencedColumnName = "oeuvre_id"))
	private List<Oeuvre> oeuvres;
	
}
