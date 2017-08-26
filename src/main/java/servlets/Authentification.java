package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Utilisateur;

/**
 * Servlet implementation class Authentification
 */
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authentification() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	// I keep only doPost() to login
	 /* protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("biblio");
		EntityManager entitymanager = emfactory.createEntityManager();

		Query query = entitymanager.createQuery("SELECT u FROM Utilisateur u"
				+ " WHERE u.email LIKE :e AND u.password LIKE :p");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		query.setParameter("e",email);
		query.setParameter("p",password);
		
		Utilisateur u = (Utilisateur) query.getSingleResult();
														
		entitymanager.close();
		emfactory.close();
		if(u != null)
		{
			response.sendRedirect("/biblio/ListeRessources");
		}
		else
		{
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
