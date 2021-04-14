package tomasn.lottery.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="share_value")
@NamedQueries(
        {
                @NamedQuery(name="ShareValue.findAll", query="SELECT a from ShareValue a")
        }
)
@Getter
@Setter
@NoArgsConstructor
public class ShareValue implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="share_value_id")
    private Integer id;

    @ManyToMany(mappedBy = "shareValues")
    Set<Draw> draw;

    @Column(name="share_winnings")
    private Integer shareWinnings;

    @Column(name="share_division")
    private String shareDivision;
}
