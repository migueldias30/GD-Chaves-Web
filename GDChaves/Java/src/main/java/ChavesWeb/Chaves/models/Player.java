package ChavesWeb.Chaves.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

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

    @Column(name = "pla_hei")
    private Double height;

    @Column(name = "pla_wei")
    private Double weight;

    @Size(max = 400)
    @NotNull
    @Column(name = "pla_info", nullable = false, length = 400)
    private String plaInfo;

    @Column(name = "pla_height")
    private Double plaHeight;

    @Column(name = "pla_weight")
    private Double plaWeight;

    public Double getPlaWeight() {
        return plaWeight;
    }

    public void setPlaWeight(Double plaWeight) {
        this.plaWeight = plaWeight;
    }

    public Double getPlaHeight() {
        return plaHeight;
    }

    public void setPlaHeight(Double plaHeight) {
        this.plaHeight = plaHeight;
    }

    public String getPlaInfo() {
        return plaInfo;
    }

    public void setPlaInfo(String plaInfo) {
        this.plaInfo = plaInfo;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
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
