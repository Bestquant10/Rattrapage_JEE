package modele;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.eclipse.persistence.internal.jpa.parsing.TemporalLiteralNode.TemporalType;

@Entity
@Table(name="t_ressource")
public class Ressource implements Serializable
{
	private  static  final  long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="ressource_titre")
	private String titre;
	
	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name="date_edition")
	private Date dateEdition;
	
	@Column(name="url")
	private String url;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Edition edition;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "auteur_ressource", joinColumns = {
			@JoinColumn(name = "auteur_id") },
			inverseJoinColumns = { @JoinColumn(name = "ressource_id")})
	private List<Auteur> auteurs;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "categorie_ressource", joinColumns = {
			@JoinColumn(name = "categorie_id") },
			inverseJoinColumns = { @JoinColumn(name = "ressource_id")})
	private List<Categorie> categories;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private TypeRessource typeRessource;

	public Ressource(){}
	
	public Ressource(String titre, Date dateEdition, String url) {
		super();
		this.titre = titre;
		this.dateEdition = dateEdition;
		this.url = url;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateEdition() {
		return dateEdition;
	}

	public void setDateEdition(Date dateEdition) {
		this.dateEdition = dateEdition;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Edition getEdition() {
		return edition;
	}

	public void setEdition(Edition edition) {
		this.edition = edition;
	}

	public List<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public TypeRessource getTypeRessource() {
		return typeRessource;
	}

	public void setTypeRessource(TypeRessource typeRessource) {
		this.typeRessource = typeRessource;
	}
	
}
