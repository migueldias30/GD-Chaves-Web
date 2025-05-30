package ChavesWeb.Chaves.controllers;

import ChavesWeb.Chaves.dto.AuthBodyDto;
import ChavesWeb.Chaves.dto.RegisterDto;
import ChavesWeb.Chaves.models.User;
import ChavesWeb.Chaves.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<? extends Serializable> login(@Valid @RequestBody AuthBodyDto user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User userData = userService.getUserByEmail(user.getEmail());
        HashMap<String, Object> response = new HashMap<>();

        if (userData != null) {
            if (bCryptPasswordEncoder.matches(user.getPassword(), userData.getPassword())) {
                response.put("success", true);
                response.put("message", "Login com sucesso");
                response.put("userId", userData.getId());
                return ResponseEntity.ok((Serializable) response);
            } else {
                response.put("success", false);
                response.put("message", "Credenciais inválidas");
                response.put("token", null);
                return ResponseEntity.status(401).body((Serializable) response);
            }
        }
        response.put("success", false);
        response.put("message", "Credenciais inválidas");
        response.put("token", null);
        return ResponseEntity.status(401).body((Serializable) response);
    }

    @PostMapping("/register")
    public ResponseEntity<? extends Serializable> register(@Valid @RequestBody RegisterDto user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        HashMap<String, Object> response = new HashMap<>();
        String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(encryptedPassword);
        newUser.setSocio(user.isMember());
        newUser.setNome(user.getNome());
        newUser.getBirthdate();

        try {
            if (userService.createUser(newUser) != null) {
                response.put("success", true);
                response.put("message", "Utilizador criado com sucesso");
                return ResponseEntity.ok((Serializable) response);
            } else {
                response.put("success", false);
                response.put("message", "Utilizador já existe");
                return ResponseEntity.status(409).body((Serializable) response);
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Erro ao criar utilizador");
            return ResponseEntity.status(500).body((Serializable) response);
        }
    }
}