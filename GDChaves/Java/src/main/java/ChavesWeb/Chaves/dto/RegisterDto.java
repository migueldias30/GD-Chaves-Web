package ChavesWeb.Chaves.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class RegisterDto {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private boolean isMember;

    private String memberNumber;

    @NotBlank
    private String nome;

    @NotBlank
    private Date birthdate;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean isMember() { return isMember; }
    public void setMember(boolean member) { this.isMember = member; }

    public String getMemberNumber() { return memberNumber; }
    public void setMemberNumber(String memberNumber) { this.memberNumber = memberNumber; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Date getBirthdate() { return birthdate; }

    public void setBirthdate(Date birthdate) { this.birthdate = birthdate; }
}
