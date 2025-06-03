package ChavesWeb.Chaves.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "competition")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comp_id")
    private Integer id;

    @Column(name = "comp_name", nullable = false, length = 60)
    private String name;

    @NotNull
    @Column(name = "comp_team_id", nullable = false)
    private Long compTeamId;

    public Long getCompTeamId() {
        return compTeamId;
    }

    public void setCompTeamId(Long compTeamId) {
        this.compTeamId = compTeamId;
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
