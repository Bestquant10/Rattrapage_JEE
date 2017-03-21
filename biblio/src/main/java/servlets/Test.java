package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JSpinner.DateEditor;

import modele.Auteur;
import modele.Edition;
import modele.Ressource;
import modele.TypeRessource;


/**
 * Servlet implementation class Test
 */
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/WEB-INF/ajouterRessource.jsp").forward(request, response);
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titreRessource = request.getParameter("titre");
		Date dateEdition = null;
		try 
		{
			 dateEdition = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dateE"));
		} 
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		String url = request.getParameter("url");
		String typeRessource = request.getParameter("typeR");
		String nomEditeur = request.getParameter("nomE");
		
		Ressource ressource = new Ressource(titreRessource,dateEdition,url);
		TypeRessource typeR = new TypeRessource(typeRessource);
		Edition edition = new Edition(nomEditeur);
		int nbr = Integer.parseInt(request.getParameter("nbr"));
		List<Auteur> auteurs = new ArrayList<Auteur>();
		for(int i=0;i<nbr;i++)
		{
			Auteur auteur = new Auteur(request.getParameter("auteurs["+i+"].nom"),request.getParameter("auteurs["+i+"].prenom"));
			auteurs.add(auteur);
		}
		ressource.setEdition(edition);
		ressource.setTypeRessource(typeR);
		ressource.setAuteurs(auteurs);
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "biblio" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    EntityTransaction tx = entitymanager.getTransaction( );
	    tx.begin();  
	    entitymanager.persist(ressource);
	    tx.commit();

	    entitymanager.close( );
	    emfactory.close( );

		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
