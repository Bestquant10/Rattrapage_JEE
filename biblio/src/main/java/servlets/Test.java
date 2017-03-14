package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JSpinner.DateEditor;

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
		// TODO Auto-generated method stub
		
		  /*EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "biblio" );
	      
	      EntityManager entitymanager = emfactory.createEntityManager( );
	      EntityTransaction tx = entitymanager.getTransaction( );
	      tx.begin();
	      

	      Auteur a = new Auteur();
	      a.setNom("iliass");
	      a.setPrenom("kahli");
	      
	      entitymanager.persist(a);
	      tx.commit();

	      entitymanager.close( );
	      emfactory.close( );*/

		
		/*PrintWriter out = response.getWriter();
		
		
		try {
			InitialContext context = new InitialContext();
			HelloWorldSessionBean hello = 
					(HelloWorldSessionBean) context.lookup("java:global/biblioEJB/HelloWorldSessionBean!com.biblio.ejb.HelloWorldSessionBean");
			out.print(hello.sayHello());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		getServletContext().getRequestDispatcher("/WEB-INF/ajouterRessource.jsp").forward(request, response);
		
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titreRessource = request.getParameter("titre");
		Date dateEdition = null;
		try {
			 dateEdition = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dateE"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = request.getParameter("url");
		String typeRessource = request.getParameter("typeR");
		String nomEditeur = request.getParameter("nomE");
		request.setAttribute("titre", titreRessource);
		
		Ressource ressource = new Ressource(titreRessource,dateEdition,url);
		TypeRessource typeR = new TypeRessource(typeRessource);
		Edition edition = new Edition(nomEditeur);
		
		ressource.setEdition(edition);
		ressource.setTypeRessource(typeR);
		
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
