package tomasn.lottery.persistence;

import tomasn.lottery.entities.Ticket;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class TicketDAO {

    @Inject
    private EntityManager em;

    public void persist(Ticket ticket){
        this.em.persist(ticket);
    }

    public Ticket findOne(Integer id){
        return em.find(Ticket.class, id);
    }

    public Ticket update(Ticket player){
        return em.merge(player);
    }
}