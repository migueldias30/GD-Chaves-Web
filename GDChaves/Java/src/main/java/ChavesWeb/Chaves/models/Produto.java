package ChavesWeb.Chaves.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prodId;

    @Column(nullable = false, length = 60)
    private String prodName;

    @Column(nullable = false, length = 200)
    private String prodFoto;

    @Column(nullable = false, length = 300)
    private String prodDesc;

    @Size(max = 20)
    @NotNull
    @Column(name = "prod_preco", nullable = false, length = 20)
    private String prodPreco;

    public String getProdPreco() {
        return prodPreco;
    }

    public void setProdPreco(String prodPreco) {
        this.prodPreco = prodPreco;
    }

    public Integer getProdId() { return prodId; }
    public void setProdId(Integer prodId) { this.prodId = prodId; }

    public String getProdName() { return prodName; }
    public void setProdName(String prodName) { this.prodName = prodName; }

    public String getProdFoto() { return prodFoto; }
    public void setProdFoto(String prodFoto) { this.prodFoto = prodFoto; }

    public String getProdDesc() { return prodDesc; }
    public void setProdDesc(String prodDesc) { this.prodDesc = prodDesc; }
}