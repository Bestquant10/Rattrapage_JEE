package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Auteur;
import modele.Edition;
import modele.Ressource;
import modele.TypeRessource;

/**
 * Servlet implementation class ModifierRessource
 */
public class ModifierRessource extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	Edition edition;
	
	@Inject
	TypeRessource typeR;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierRessource() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // I keep only doPost to modify info of books
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "biblio" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    Ressource ressource = entitymanager.find(Ressource.class,id); 
	    entitymanager.close( );
	    emfactory.close( );
	    request.setAttribute("ressource", ressource);
		
	    getServletContext().getRequestDispatcher("/WEB-INF/modifierRessource.jsp").forward(request, response);
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		String titreRessource = request.getParameter("titre");
		Date dateEdition = null;
		try {
			dateEdition = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dateE"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String url = request.getParameter("url");
		String typeRessource = request.getParameter("typeR");
		String nomEditeur = request.getParameter("nomE");

		
		int nbr = 0;
		if (!request.getParameter("nbr").equals("")) {
			nbr = Integer.parseInt(request.getParameter("nbr"));
		}
		
		List<Auteur> auteurs = new ArrayList<Auteur>();
		for (int i = 0; i < nbr; i++) {
			Auteur auteur = new Auteur(request.getParameter("auteurs[" + i + "].nom"),
					request.getParameter("auteurs[" + i + "].prenom"));
			auteurs.add(auteur);
		}
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("biblio");
		EntityManager entitymanager = emfactory.createEntityManager();
		Ressource ressource = entitymanager.find(Ressource.class,id);
		ressource.setTitre(titreRessource);
		ressource.setDateEdition(dateEdition);
		ressource.setUrl(url);
		//Edition edition = new Edition(nomEditeur);
		edition.setNom(nomEditeur);
		//TypeRessource typeR = new TypeRessource(typeRessource);
	     typeR.setNom(typeRessource);
		ressource.setEdition(edition);
		ressource.setTypeRessource(typeR);
		ressource.setAuteurs(auteurs);
		EntityTransaction tx = entitymanager.getTransaction();
		tx.begin();
		entitymanager.merge(ressource);
		tx.commit();

		entitymanager.close();
		emfactory.close();

		response.sendRedirect("/biblio/ListeRessources");
	}

}
