package ChavesWeb.Chaves.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "encomenda")
public class Encomenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer encId;

    @Column(nullable = false)
    private Integer encSocioId;

    @Column(nullable = false)
    private LocalDate encDate;

    @Column(nullable = false, length = 90)
    private String encAdress;

    public Integer getEncId() { return encId; }
    public void setEncId(Integer encId) { this.encId = encId; }

    public Integer getEncSocioId() { return encSocioId; }
    public void setEncSocioId(Integer encSocioId) { this.encSocioId = encSocioId; }

    public LocalDate getEncDate() { return encDate; }
    public void setEncDate(LocalDate encDate) { this.encDate = encDate; }

    public String getEncAdress() { return encAdress; }
    public void setEncAdress(String encAdress) { this.encAdress = encAdress; }
}
