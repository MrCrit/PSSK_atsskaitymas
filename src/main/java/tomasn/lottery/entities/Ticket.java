package tomasn.lottery.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NamedQueries(
        {
                @NamedQuery(name="Ticket.findById", query="SELECT a from Ticket a WHERE a.id = :id"),
                @NamedQuery(name="Ticket.findAll", query="SELECT a from Ticket as a")
        }
)
@Table(name="ticket")
@Getter @Setter @NoArgsConstructor
public class Ticket implements Serializable {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="ticket_id")
        private Integer id;

        @Column(name="purchase_time")
        private LocalDateTime time;

        @ManyToOne
        @JoinColumn(name="draw_id")
        private Draw draw;

        private String numbers;

        @Column(name="ticket_winnings")
        private Integer winnings;

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Ticket ticket = (Ticket) o;
                return Objects.equals(id, ticket.id) &&
                        Objects.equals(time, ticket.time) &&
                        Objects.equals(winnings, ticket.winnings);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, time);
        }
}
