package tomasn.lottery.usecases;

import lombok.Getter;
import lombok.Setter;
import tomasn.lottery.entities.Draw;
import tomasn.lottery.entities.ShareValue;
import tomasn.lottery.entities.Ticket;
import tomasn.lottery.persistence.DrawDAO;
import tomasn.lottery.persistence.ShareValueDAO;
import tomasn.lottery.persistence.TicketDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Model
public class Tickets implements Serializable {

    @Inject
    private DrawDAO drawsDAO;

    @Inject
    private TicketDAO ticketsDAO;

    @Inject
    private ShareValueDAO shareValueDAO;

    @Getter @Setter
    private Draw draw;


    @Getter @Setter
    private Ticket ticketToCreate = new Ticket();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer drawId = Integer.parseInt(requestParameters.get("drawId"));
        this.draw = drawsDAO.findOne(drawId);
    }

    @Transactional
    public String createTicket() {
        ticketToCreate.setDraw(this.draw);
        ticketsDAO.persist(ticketToCreate);
        return "tickets?faces-redirect=true&drawId=" + this.draw.getId();
    }

    @Transactional
    public String addShare(int shareId){
        Set<ShareValue> shareValuesNew = draw.getShareValues();
        shareValuesNew.add(shareValueDAO.findOne(shareId));
        draw.setShareValues(shareValuesNew);
        this.drawsDAO.persist(draw);
        return "tickets?faces-redirect=true&drawId=" + this.draw.getId();
    }
}