package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
public class GetAllNotices extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetAllNotices() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("<ul>");
		out.write("<li>Jasmin, Claude. Le gamin</li>");
		out.write("<li>Ricard, François. La génération lyrique</li>");
		out.write("<li>Mailhot, Laurent, et Benoît Melançon. Le Conseil des arts du Canada, 1957-1982</li>");
		out.write("<li>Bélanger, Jules, Marc Desjardins et Yves Frenette. Histoire de la Gaspésie</li>");
		out.write("<li>Canada. Ministère des Communications. Rapport annuel 1969-1970</li>");
		out.write("<li>Québec. Commission de toponymie. Répertoire toponymique du Québec</li>");
		out.write("</ul>");
		out.write("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
