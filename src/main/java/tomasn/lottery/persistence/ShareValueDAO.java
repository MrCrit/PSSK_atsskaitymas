package tomasn.lottery.persistence;


import tomasn.lottery.entities.ShareValue;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ShareValueDAO {

    @Inject
    private EntityManager em;

    public List<ShareValue> loadAll(){
        return em.createNamedQuery("ShareValue.findAll", ShareValue.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(ShareValue share){
        this.em.persist(share);
    }

    public ShareValue findOne(Integer id) {
        return em.find(ShareValue.class, id);
    }
}
