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

/**
 * Servlet implementation class supprimerTypeRessource
 */
public class SupprimerTypeRessource extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
    private  TypeRessource typeRessource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerTypeRessource() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "biblio" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    
	    // Find the Ressource with the id typeRessource
	    Long idRessource = Long.parseLong(request.getParameter("idRessource"));
	   
	    typeRessource = entitymanager.find(TypeRessource.class, idRessource);
	    
	    EntityTransaction tx = entitymanager.getTransaction();
	    tx.begin();  
	    if (typeRessource != null) {
	    	entitymanager.remove(typeRessource);
	    }
	    tx.commit();
	    entitymanager.close( );
	    emfactory.close( );
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
