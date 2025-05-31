package ChavesWeb.Chaves.controllers;

import ChavesWeb.Chaves.dto.AuthBodyDto;
import ChavesWeb.Chaves.dto.RegisterDto;
import ChavesWeb.Chaves.models.ReturnUser;
import ChavesWeb.Chaves.models.User;
import ChavesWeb.Chaves.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<? extends Serializable> getUsers(@Valid @PathVariable int id) {
        User userData = userService.getUserById((long) id);
        ReturnUser returnUser = new ReturnUser();
        returnUser.setBirthdate(userData.getBirthdate().toString());
        returnUser.setEmail(userData.getEmail());
        returnUser.setId(userData.getId());
        returnUser.setNome(userData.getNome());
        returnUser.setMemberNumber(String.valueOf(userData.getMemberNumber()));
        returnUser.setRole(userData.getRole());
        returnUser.setSocio(userData.isSocio());
        HashMap<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("userData", returnUser);
        return ResponseEntity.status(200).body((Serializable) response);
    }
}
