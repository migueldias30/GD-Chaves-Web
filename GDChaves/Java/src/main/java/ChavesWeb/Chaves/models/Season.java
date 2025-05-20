package ChavesWeb.Chaves.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "season")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seas_id")
    private Long id;

    @Column(name = "seas_name", nullable = false, length = 60)
    private String name;

    @Column(name = "seas_dt_in")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "seas_dt_out")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
