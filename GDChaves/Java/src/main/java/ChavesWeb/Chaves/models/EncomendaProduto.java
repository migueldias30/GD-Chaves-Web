package ChavesWeb.Chaves.models;

import jakarta.persistence.*;

@Entity
@Table(name = "encomendaproduto")
public class EncomendaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer encprodId;

    @Column(nullable = false)
    private Integer encprodProdId;

    @Column(nullable = false)
    private Integer encprodEncId;

    public Integer getEncprodId() { return encprodId; }
    public void setEncprodId(Integer encprodId) { this.encprodId = encprodId; }

    public Integer getEncprodProdId() { return encprodProdId; }
    public void setEncprodProdId(Integer encprodProdId) { this.encprodProdId = encprodProdId; }

    public Integer getEncprodEncId() { return encprodEncId; }
    public void setEncprodEncId(Integer encprodEncId) { this.encprodEncId = encprodEncId; }
}
