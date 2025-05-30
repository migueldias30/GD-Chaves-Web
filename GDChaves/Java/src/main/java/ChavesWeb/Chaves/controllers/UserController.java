package ChavesWeb.Chaves.controllers;

import ChavesWeb.Chaves.dto.AuthBodyDto;
import ChavesWeb.Chaves.dto.RegisterDto;
import ChavesWeb.Chaves.models.ReturnUser;
import ChavesWeb.Chaves.models.User;
import ChavesWeb.Chaves.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.HashMap;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<? extends Serializable> getUsers(@Valid @RequestBody int id) {
        User userData = userService.getUserById((long) id);
        ReturnUser returnUser = new ReturnUser();
        returnUser.setBirthdate(userData.getBirthdate());
        returnUser.setEmail(userData.getEmail());
        returnUser.setId(userData.getId());
        returnUser.setNome(userData.getNome());
        returnUser.setMemberNumber(String.valueOf(userData.getMemberNumber()));
        returnUser.setRole(userData.getRole());
        HashMap<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("userData", returnUser);
        return ResponseEntity.status(200).body((Serializable) response);
    }
}
