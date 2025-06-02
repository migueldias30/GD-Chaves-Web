package ChavesWeb.Chaves.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pla_id")
    private Integer id;

    @Column(name = "pla_name", nullable = false, length = 60)
    private String name;

    @Column(name = "pla_bdate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "pla_anos", nullable = false, length = 60)
    private String years;

    @Column(name = "pla_num", nullable = false, length = 60)
    private String number;

    @Column(name = "pla_nac", nullable = false, length = 60)
    private String nationality;

    @Column(name = "pla_foto", length = 200)
    private String photo;

    @Size(max = 400)
    @NotNull
    @Column(name = "pla_info", nullable = false, length = 400)
    private String plaInfo;

    @Size(max = 20)
    @NotNull
    @Column(name = "pla_wei", nullable = false, length = 20)
    private String plaWei;

    @Size(max = 20)
    @NotNull
    @Column(name = "pla_hei", nullable = false, length = 20)
    private String plaHei;

    @OneToMany(mappedBy = "player")
    private Set<ChavesPlayer> chavesplayers = new LinkedHashSet<>();

    public Set<ChavesPlayer> getChavesplayers() {
        return chavesplayers;
    }

    public void setChavesplayers(Set<ChavesPlayer> chavesplayers) {
        this.chavesplayers = chavesplayers;
    }

    public String getPlaHei() {
        return plaHei;
    }

    public void setPlaHei(String plaHei) {
        this.plaHei = plaHei;
    }

    public String getPlaWei() {
        return plaWei;
    }

    public void setPlaWei(String plaWei) {
        this.plaWei = plaWei;
    }

    public String getPlaInfo() {
        return plaInfo;
    }

    public void setPlaInfo(String plaInfo) {
        this.plaInfo = plaInfo;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
