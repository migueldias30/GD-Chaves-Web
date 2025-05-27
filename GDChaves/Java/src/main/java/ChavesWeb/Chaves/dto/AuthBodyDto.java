package ChavesWeb.Chaves.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class AuthBodyDto {

    @Email(message = "Pedido inválido")
    private String email;

    @NotNull(message = "Pedido inválido")
    private String password;

    public AuthBodyDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}