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
 * Servlet implementation class ajouterTypeRessource
 */
public class AjouterTypeRessource extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
    private  TypeRessource typeRessource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterTypeRessource() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // I keep only doPost() because I dont need doget() for this context
    /*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/WEB-INF/ajouterTypeRessource.jsp").forward(request, response);
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomTypeRessource = request.getParameter("typeRessource");
		typeRessource.setNom(nomTypeRessource);
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "biblio" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    EntityTransaction tx = entitymanager.getTransaction( );
	    tx.begin();  
	    entitymanager.persist(typeRessource);
	    tx.commit();
	    entitymanager.close( );
	    emfactory.close( );
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
