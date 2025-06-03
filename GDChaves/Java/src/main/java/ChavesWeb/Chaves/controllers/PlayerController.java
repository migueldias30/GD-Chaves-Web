package ChavesWeb.Chaves.controllers;

import ChavesWeb.Chaves.models.Player;
import ChavesWeb.Chaves.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Integer id) {
        return playerService.getPlayerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Integer id, @RequestBody Player playerDetails) {
        return playerService.getPlayerById(id)
                .map(player -> ResponseEntity.ok(playerService.updatePlayer(id, playerDetails)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Integer id) {
        if (playerService.getPlayerById(id).isPresent()) {
            playerService.deletePlayer(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/withPosition")
    public ResponseEntity<List<HashMap<String, Object>>> getPlayersWithPosition() {
        List<Player> results = playerService.getAllPlayersWithPosition();
        List<HashMap<String, Object>> mapped = results.stream().map(obj -> {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", obj.getId());
            map.put("name", obj.getName());
            map.put("birthdate", obj.getBirthDate());
            map.put("number", obj.getNumber());
            map.put("nationality", obj.getNationality());
            map.put("photo", obj.getPhoto());
            map.put("height", obj.getHeight());
            map.put("weight", obj.getWeight());
            return map;
        }).toList();
        return ResponseEntity.ok(mapped);
    }
}
