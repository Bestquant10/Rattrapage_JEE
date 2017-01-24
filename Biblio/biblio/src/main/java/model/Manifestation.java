package model;

import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "Manifestation")
public class Manifestation
{
	
	
	//@Id @GeneratedValue
	//@Column(name = "manifestation_id")
	private int id;
	
	//@Column(name = "titre")
	private String titre;
	
	//@Column(name = "mention_responsabilite")
	private String mentionResponsabilite;
	
	//@Column(name = "mention_edition")
	private int mentionEdition;
	
	//@Column(name = "lieu_edition")
	private String lieuEdition;
	
	//@Column(name = "editeur")
	private String editeur;
	
	//@Column(name = "date_edition")
	private Date dateEdition;
	
	//@ManyToMany(mappedBy = "manifestations")
	private List<Expression> expressions;
	
	//@OneToMany(mappedBy = "manifestation")
	private List<Item> items;
	
	
	
}
