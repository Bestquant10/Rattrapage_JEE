package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Ressource;
import modele.TypeRessource;

/**
 * Servlet implementation class ListeRessources
 */
public class ListeRessources extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeRessources() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("biblio");
	      EntityManager entitymanager = emfactory.createEntityManager( );
	      
	      Query query = entitymanager.createQuery("SELECT r FROM Ressource r");
	      
	      PrintWriter out = response.getWriter();
	      List ressources = query.getResultList();
	      request.setAttribute("test","okok");
	      request.setAttribute("ressources", ressources);
	      entitymanager.close( );
	      emfactory.close( );
	      getServletContext().getRequestDispatcher("/WEB-INF/listeRessources.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
