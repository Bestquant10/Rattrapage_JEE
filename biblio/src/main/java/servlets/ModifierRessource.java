package servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Ressource;

/**
 * Servlet implementation class ModifierRessource
 */
public class ModifierRessource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "biblio" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    Ressource ressource = entitymanager.find(Ressource.class,id); 
	    entitymanager.close( );
	    emfactory.close( );
	    request.setAttribute("ressource", ressource);
		
	    getServletContext().getRequestDispatcher("/WEB-INF/modifierRessource.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
