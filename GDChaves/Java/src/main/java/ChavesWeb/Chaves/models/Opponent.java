package ChavesWeb.Chaves.models;

import jakarta.persistence.*;

@Entity
@Table(name = "opponent")
public class Opponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "opp_id")
    private Integer id;

    @Column(name = "opp_name", nullable = false, length = 60)
    private String name;

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
