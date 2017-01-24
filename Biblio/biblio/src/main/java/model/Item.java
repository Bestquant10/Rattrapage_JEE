package model;

//@Entity
//@Table(name = "Item")
public class Item
{
	
	
	//@Id @GeneratedValue
	//@Column(name = "item_id")
	private int id;
	
	//@Column(name = "code")
	private String code;
	
	//@Column(name = "empreinte")
	private String empreinte;
	
	//@ManyToOne
	//@JoinColumn(name="manifestation_id")
	private Oeuvre manifestation;
}
