package ChavesWeb.Chaves.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "stadium")
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sta_id")
    private Integer id;

    @Column(name = "sta_name", nullable = false, length = 90)
    private String name;

    @Column(name = "sta_adress", nullable = false, length = 90)
    private String address;

    @Column(name = "sta_foto", length = 200)
    private String photo;

    @OneToMany(mappedBy = "stadium")
    @JsonManagedReference
    private List<Game> games;

    public Set<Game> getGames() {
        return (Set<Game>) games;
    }

    public void setGames(Set<Game> games) {
        this.games = (List<Game>) games;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
