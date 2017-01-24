package model;

import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "Expression")
public class Expression
{
	
	//@Id @GeneratedValue
	//@Column(name = "expression_id")
	private int id;
	
	//@Column(name = "titre")
	private String titre;
	
	//@Column(name = "forme")
	private String forme;
	
	//@Column(name = "date_expression")
	private Date dateExpression;
	
	//@Column(name = "langue")
	private String langue;
	
	//@ManyToOne
	//@JoinColumn(name="oeuvre_id")
	private Oeuvre oeuvre;
	
	//@ManyToMany
	//@JoinTable(name ="Expression_Manifestation", 
	//joinColumns = @JoinColumn(name = "expression_id", referencedColumnName = "expression_id"),
	//inverseJoinColumns = @JoinColumn(name ="manifestation_id", referencedColumnName = "manifestation_id"))
	private List<Manifestation> manifestations;   
	
	
}
