package servlets;

import bean.UtilisateurBean;
import modele.Utilisateur;
import org.mindrot.jbcrypt.BCrypt;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Connexion extends HttpServlet {
    public static final String VIEW_CONNEXION = "/WEB-INF/connexion.jsp";
    @EJB
    private UtilisateurBean utilisateurBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VIEW_CONNEXION).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Utilisateur u = utilisateurBean.getByEmail(email.trim());

        if(u != null) {
            // Check mot de passe
            boolean password_ok = BCrypt.checkpw(password, u.getMotDePasse());
            if(password_ok) {
                HttpSession session = req.getSession();
                session.setAttribute("user", u);
                resp.sendRedirect(req.getContextPath() + "/");
                return;
            }
        }

        // Erreur : email ou mot de passe incorrect.
        req.setAttribute("bad_credentials", new Boolean(true));
        this.getServletContext().getRequestDispatcher(VIEW_CONNEXION).forward(req, resp);
    }
}
