package ChavesWeb.Chaves.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "encomenda")
public class Encomenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer encId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate encDate;

    @Column(nullable = false, length = 90)
    private String encAdress;

    @ManyToOne
    @JoinColumn(name = "enc_users_id", nullable = true)
    private User user;

    @OneToMany(mappedBy = "encomenda", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<EncomendaProduto> produtos;

    // Getters e setters
    public Integer getEncId() { return encId; }
    public void setEncId(Integer encId) { this.encId = encId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getEncDate() { return encDate; }
    public void setEncDate(LocalDate encDate) { this.encDate = encDate; }

    public String getEncAdress() { return encAdress; }
    public void setEncAdress(String encAdress) { this.encAdress = encAdress; }

    public List<EncomendaProduto> getProdutos() { return produtos; }
    public void setProdutos(List<EncomendaProduto> produtos) { this.produtos = produtos; }
}
