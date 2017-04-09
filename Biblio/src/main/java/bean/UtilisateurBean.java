package bean;

import modele.Utilisateur;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "UtilisateurEJB")
public class UtilisateurBean {
    @PersistenceContext(unitName = "biblioPersistenceUnit")
    private EntityManager em;

    public UtilisateurBean() {
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        em.persist(utilisateur);
        return utilisateur;
    }

    public Utilisateur getByEmail(String email) {
        Query q = em.createQuery("SELECT u FROM Utilisateur u WHERE u.email = :email")
                .setParameter("email", email);
        Utilisateur user;
        try {
            user = (Utilisateur) q.getSingleResult();
        } catch (NoResultException noresult) {
            user = null;
        }
        return user;
    }
}
