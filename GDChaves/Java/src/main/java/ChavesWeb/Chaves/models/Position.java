package ChavesWeb.Chaves.models;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "pos_id") 
    private Integer id;

    @Column(name = "pos_name", nullable = false, length = 60) 
    private String name;

    @OneToMany(mappedBy = "position")
    private Set<ChavesPlayer> chavesplayers = new LinkedHashSet<>();

    public Set<ChavesPlayer> getChavesplayers() {
        return chavesplayers;
    }

    public void setChavesplayers(Set<ChavesPlayer> chavesplayers) {
        this.chavesplayers = chavesplayers;
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




