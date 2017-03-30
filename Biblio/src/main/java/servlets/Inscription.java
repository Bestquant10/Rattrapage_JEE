package servlets;

import bean.UtilisateurBean;
import modele.Utilisateur;
import javafx.util.Pair;
import org.mindrot.jbcrypt.BCrypt;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class Inscription extends HttpServlet {
    @EJB
    private UtilisateurBean utilisateurBean;
    @EJB
    private ServletContext ctx = null;

    public static final String VIEW_INSCRIPTION = "/WEB-INF/inscription.jsp";
    private static final int PASSWORD_MIN_LENGTH = 8;

    public void init(ServletConfig config) throws  ServletException {
        super.init(config);
        ctx = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("password_min_length", PASSWORD_MIN_LENGTH);
        this.getServletContext().getRequestDispatcher(VIEW_INSCRIPTION).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // Compte
        String prenom = req.getParameter("prenom");
        String nom = req.getParameter("nom");
        String email = req.getParameter("email");
        String tel = req.getParameter("tel");
        String password = req.getParameter("password");
        String password_repeat = req.getParameter("password_repeat");


        boolean un_champ_est_vide = prenom.isEmpty() || nom.isEmpty() || email.isEmpty() || tel.isEmpty() || password.isEmpty() || password_repeat.isEmpty();
        boolean formulaire_mal_rempli = un_champ_est_vide || !isEmailValid(email) || !isPasswordValid(password, password_repeat);

        if(formulaire_mal_rempli) {
//            // TODO: Faire remonter les erreurs sur la vue.
//            req.setAttribute("form_error", "Les champs du formulaire sont mal remplis.");
//            this.getServletContext().getRequestDispatcher(VIEW_INSCRIPTION).forward(req, resp);
            resp.getWriter().println("Les champs du formulaire sont mal remplis.");
            return;
        }

        Utilisateur existing_user = utilisateurBean.getByEmail(email);
        if(existing_user != null) {
//            req.setAttribute("form_error", "Un compte est déjà enregistré avec cet email.");
//            this.getServletContext().getRequestDispatcher(VIEW_INSCRIPTION).forward(req, resp);
            resp.getWriter().println("Un compte est déjà enregistré avec cet email.");
            return;
        }

       

        Utilisateur u = new Utilisateur();
        u.setPrenom(prenom.trim());
        u.setNom(nom.trim());
        u.setEmail(email.trim());
        u.setTelephone(tel.trim());
        u.setMotDePasse(BCrypt.hashpw(password, BCrypt.gensalt()));
        utilisateurBean.createUtilisateur(u);

        resp.sendRedirect(req.getContextPath() + "/");
    }

    private boolean isEmailValid(String email) {
        return email.indexOf('@') >= 0;
    }

    private boolean isPasswordValid(String password, String repeat) {
        boolean passwords_matches = password.equals(repeat);
        boolean good_length = password.length() >= PASSWORD_MIN_LENGTH;
        return passwords_matches && good_length;
    }
}
