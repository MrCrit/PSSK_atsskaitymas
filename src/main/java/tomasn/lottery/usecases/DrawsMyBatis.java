package tomasn.lottery.usecases;

import lombok.Getter;
import lombok.Setter;
import tomasn.lottery.mybatis.dao.DrawMapper;
import tomasn.lottery.mybatis.model.Draw;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class DrawsMyBatis {

    @Inject
    private DrawMapper drawMapper;

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
        this.drawMapper.insert(DrawToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllDraws(){
        this.allDraws = drawMapper.selectAll();
    }

}