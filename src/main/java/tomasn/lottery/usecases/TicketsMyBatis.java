package tomasn.lottery.usecases;

import lombok.Getter;
import lombok.Setter;
import tomasn.lottery.mybatis.dao.DrawMapper;
import tomasn.lottery.mybatis.dao.TicketMapper;
import tomasn.lottery.mybatis.model.Draw;
import tomasn.lottery.mybatis.model.Ticket;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Model
public class TicketsMyBatis implements Serializable {

    @Inject
    private DrawMapper drawsMapper;

    @Inject
    private TicketMapper ticketsMapper;

    @Getter @Setter
    private Draw draw;

    @Getter @Setter
    private List<Ticket> tickets;

    @Getter @Setter
    private Ticket ticketToCreate = new Ticket();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer drawId = Integer.parseInt(requestParameters.get("drawId"));
        this.draw = drawsMapper.selectByPrimaryKey(drawId);
        this.tickets = ticketsMapper.selectByDrawId(drawId);
    }

    @Transactional
    public String createTicket() {
        ticketToCreate.setDrawId(this.draw.getDrawId());
        ticketsMapper.insert(ticketToCreate);
        return "tickets?faces-redirect=true&drawId=" + this.draw.getDrawId();
    }

}