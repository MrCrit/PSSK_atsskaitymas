package tomasn.lottery.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="draw")
@NamedQueries(
        {
                @NamedQuery(name="Draw.findAll", query="SELECT a from Draw as a")
        }
)
@Getter @Setter @NoArgsConstructor
public class Draw implements Serializable {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="draw_id")
        private Integer id;

        @Column(name="close_time")
        private LocalDateTime time;

        private String numbers;

        @OneToMany(
                mappedBy = "draw"
        )
        Set<Ticket> tickets;

        @ManyToMany
        @JoinTable(
                name="draw_share",
                joinColumns = @JoinColumn(name="draw_id"),
                inverseJoinColumns = @JoinColumn(name="share_value_id")
        )
        Set<ShareValue> shareValues;
}
