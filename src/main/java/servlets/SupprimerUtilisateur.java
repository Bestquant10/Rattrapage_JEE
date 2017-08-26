package servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.TypeRessource;
import modele.Utilisateur;

/**
 * Servlet implementation class SupprimerUtilisateur
 */
public class SupprimerUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	Utilisateur u;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //I keep only doPost() to register
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		Long idRessource = Long.parseLong(request.getParameter("email"));
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "biblio" );
	    EntityManager entitymanager = emfactory.createEntityManager( );  
	    u = entitymanager.find(Utilisateur.class, idRessource);
	    
	    EntityTransaction tx = entitymanager.getTransaction();
	    tx.begin();  
	    if (u != null) {
	    	entitymanager.remove(u);
	    }
	    tx.commit();
	    entitymanager.close( );
	    emfactory.close( );
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
