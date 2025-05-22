package ChavesWeb.Chaves.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "socio")
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer socioId;

    @Column(nullable = false, length = 60)
    private String socioName;

    @Column(nullable = false, length = 60)
    private String socioNum;

    @Column(nullable = false, length = 60)
    private String socioEmail;

    @Column(nullable = false)
    private LocalDate socioBdate;

    public Integer getSocioId() { return socioId; }
    public void setSocioId(Integer socioId) { this.socioId = socioId; }

    public String getSocioName() { return socioName; }
    public void setSocioName(String socioName) { this.socioName = socioName; }

    public String getSocioNum() { return socioNum; }
    public void setSocioNum(String socioNum) { this.socioNum = socioNum; }

    public String getSocioEmail() { return socioEmail; }
    public void setSocioEmail(String socioEmail) { this.socioEmail = socioEmail; }

    public LocalDate getSocioBdate() { return socioBdate; }
    public void setSocioBdate(LocalDate socioBdate) { this.socioBdate = socioBdate; }
}
