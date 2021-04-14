package tomasn.lottery.persistence;


import tomasn.lottery.entities.Draw;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class DrawDAO {

    @Inject
    private EntityManager em;

    public List<Draw> loadAll(){
        return em.createNamedQuery("Draw.findAll", Draw.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Draw draw){
        this.em.persist(draw);
    }

    public Draw findOne(Integer id) {
        return em.find(Draw.class, id);
    }
}
