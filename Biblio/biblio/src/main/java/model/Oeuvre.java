package model;

import java.util.Date;
import java.util.List;

public class Oeuvre
{
	private static final long serialVersionUID = 1L;

	//@Id @GeneratedValue
	//@Column(name = "oeuvre_id")
	private int id;
	
	//@Column(name = "titre")
	private String titre;
	
	//@Column(name = "forme")
	private String forme;
	
	//@Column(name = "date_creation")
	private Date dateCreation;
	
	//@Column(name = "autre_caracteristique")
	private String autreCaracteristique;
	
	//@Column(name = "completude_visee")
	private String completudeVisee;
	
	//@Column(name = "public_vise")
	private String publicVise;
	
	//@Column(name = "contexte")
	private String contexte;
	
	//@Column(name = "distribution_execution")
	private String distributionExecution; // oeuvre musicale
	
	//@Column(name = "reference_numerique")
	private String referenceNumerique; // oeuvre musicale
	
	//@Column(name = "tonalite")
	private String tonalite; // oeure musicale
	
	//@Column(name = "coordonnees")
	private String coordonnees; // oeuvre cartographique
	
	//@Column(name = "equinoxe")
	private String equinoxe; // oeuvre cartographique
	
	//@OneToMany(mappedBy = "oeuvre")
	private List<Expression> expressions;
	
	//@OneToMany(mappedBy = "oeuvre")
	private List<Personne> personnes;
	
	//@OneToMany(mappedBy = "oeuvre")
	private List<Collectivite> collectivites;

	public Oeuvre(int id, String titre, String forme, Date dateCreation) {
		super();
		this.id = id;
		this.titre = titre;
		this.forme = forme;
		this.dateCreation = dateCreation;
	}
	
	
}
