package ChavesWeb.Chaves.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "encomendaproduto")
public class EncomendaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "encprod_id", nullable = false)
    private Integer id;

    @Column(name = "encprod_prod_id", nullable = false)
    private Integer encprodProdId;

    @ManyToOne
    @JoinColumn(name = "encprod_enc_id")
    @JsonBackReference
    private Encomenda encomenda;

    private String nome;
    private double preco;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getEncprodProdId() { return encprodProdId; }
    public void setEncprodProdId(Integer encprodProdId) { this.encprodProdId = encprodProdId; }

    public Encomenda getEncomenda() { return encomenda; }
    public void setEncomenda(Encomenda encomenda) { this.encomenda = encomenda; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
}