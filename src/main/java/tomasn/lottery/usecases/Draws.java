package tomasn.lottery.usecases;

import lombok.Getter;
import lombok.Setter;
import tomasn.lottery.entities.Draw;
import tomasn.lottery.persistence.DrawDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Draws {

    @Inject
    private DrawDAO drawDAO;

    @Getter @Setter
    private Draw DrawToCreate = new Draw();

    @Getter
    private List<Draw> allDraws;

    @PostConstruct
    public void init(){
        loadAllDraws();
    }

    @Transactional
    public String createDraw(){
        this.drawDAO.persist(DrawToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllDraws(){
        this.allDraws = drawDAO.loadAll();
    }

}