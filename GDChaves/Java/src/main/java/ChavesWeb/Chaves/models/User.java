package ChavesWeb.Chaves.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @Size(max = 255)
    @NotNull
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean socio = false;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isSocio() { return socio; }
    public void setSocio(boolean socio) { this.socio = socio; }
}