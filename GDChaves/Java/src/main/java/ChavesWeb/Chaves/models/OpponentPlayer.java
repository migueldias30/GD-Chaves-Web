package ChavesWeb.Chaves.models;

import jakarta.persistence.*;

@Entity
@Table(name = "opponentplayer")
public class OpponentPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oppla_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "oppla_pla_id", nullable = false)
    private Player player;

    @ManyToOne
    @JoinColumn(name = "oppla_opp_id", nullable = false)
    private Opponent opponent;

    @ManyToOne
    @JoinColumn(name = "oppla_pos_id", nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "oppla_seas_id", nullable = false)
    private Season season;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Opponent getOpponent() {
        return opponent;
    }

    public void setOpponent(Opponent opponent) {
        this.opponent = opponent;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
