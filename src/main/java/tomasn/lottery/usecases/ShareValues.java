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

@Model
public class ShareValues implements Serializable {

    @Inject
    private ShareValueDAO shareValueDAO;

    @Getter
    private List<ShareValue> allShareValues;

    @Getter @Setter
    private ShareValue shareValueToCreate = new ShareValue();

    @Transactional
    public String createShareValue() {
        this.shareValueDAO.persist(shareValueToCreate);
        return "index?faces-redirect=true";
    }

    @PostConstruct
    public void init() {
        loadAllShareValues();
    }

    private void loadAllShareValues(){
        this.allShareValues = shareValueDAO.loadAll();
    }

}