package model;

import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "Collectivite")
public class Collectivite
{
	
	//@Id @GeneratedValue
	//@Column(name = "collectivite_id")
	private int id;
	
	//@Column(name = "numerotation")
	private int numerotation;
	
	//@Column(name = "localisation")
	private String localisation;
	
	//@Column(name = "date_collectivite")
	private Date dateCollectivite;
	
	//@ManyToMany
	//@JoinTable(name ="Oeuvre_Collectivite", 
	//joinColumns = @JoinColumn(name = "collectivite_id", referencedColumnName = "collectivite_id"),
	//inverseJoinColumns = @JoinColumn(name ="oeuvre_id", referencedColumnName = "oeuvre_id"))
	private List<Oeuvre> oeuvres;
}
