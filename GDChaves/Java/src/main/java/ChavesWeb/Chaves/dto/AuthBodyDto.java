package ChavesWeb.Chaves.dto;

import jakarta.validation.constraints.NotBlank;

public class AuthBodyDto {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private boolean socio;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean isSocio() { return socio; }
    public void setSocio(boolean socio) { this.socio = socio; }
}