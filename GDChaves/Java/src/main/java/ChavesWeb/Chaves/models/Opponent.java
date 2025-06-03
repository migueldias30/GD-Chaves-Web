package ChavesWeb.Chaves.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "opponent")
public class Opponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "opp_id")
    private Integer id;

    @Column(name = "opp_name", nullable = false, length = 60)
    private String name;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comp_id")
    private Competition comp;

    @OneToMany(mappedBy = "opponent")
    @JsonIgnore
    private Set<Game> games = new LinkedHashSet<>();

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public Competition getComp() {
        return comp;
    }

    public void setComp(Competition comp) {
        this.comp = comp;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
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
}
