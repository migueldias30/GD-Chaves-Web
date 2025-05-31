package ChavesWeb.Chaves.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class RegisterDto {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotNull
    @JsonProperty("isMember")
    private boolean member;

    private String memberNumber;

    @NotBlank
    private String nome;

    @NotBlank
    private String birthdate;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean isMember() { return member; }
    public void setMember(boolean member) { this.member = member; }

    public String getMemberNumber() { return memberNumber; }
    public void setMemberNumber(String memberNumber) { this.memberNumber = memberNumber; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getBirthdate() { return birthdate; }

    public void setBirthdate(String birthdate) { this.birthdate = birthdate; }
}
