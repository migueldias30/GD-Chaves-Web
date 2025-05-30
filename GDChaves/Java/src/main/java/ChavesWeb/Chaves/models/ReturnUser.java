package ChavesWeb.Chaves.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "users")
public class ReturnUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean socio = false;

    private String memberNumber;

    @Column(nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date birthdate;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public boolean isSocio() { return socio; }
    public void setSocio(boolean socio) { this.socio = socio; }

    public String getMemberNumber() { return memberNumber; }
    public void setMemberNumber(String memberNumber) { this.memberNumber = memberNumber; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Date getBirthdate(Date birthdate) { return this.birthdate; }
    public void setBirthdate(Date birthdate) { this.birthdate = birthdate; }
}
