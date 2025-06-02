package ChavesWeb.Chaves.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Integer id;

    @Column(name = "game_name", nullable = false, length = 60)
    private String name;

    @Column(name = "game_dt", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "game_sta_id")
    private Stadium stadium;

    @ManyToOne
    @JoinColumn(name = "game_comp_id", nullable = false)
    private Competition competition;

    @ManyToOne
    @JoinColumn(name = "game_opp_id")
    private Opponent opponent;

    @Size(max = 40)
    @NotNull
    @Column(name = "game_hr", nullable = false, length = 40)
    private String gameHr;

    @Size(max = 20)
    @Column(name = "game_res", length = 20)
    private String gameRes;

    public String getGameRes() {
        return gameRes;
    }

    public void setGameRes(String gameRes) {
        this.gameRes = gameRes;
    }

    public String getGameHr() {
        return gameHr;
    }

    public void setGameHr(String gameHr) {
        this.gameHr = gameHr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Opponent getOpponent() {
        return opponent;
    }

    public void setOpponent(Opponent opponent) {
        this.opponent = opponent;
    }
}
