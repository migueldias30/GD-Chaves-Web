package ChavesWeb.Chaves.controllers;

import ChavesWeb.Chaves.models.ChavesPlayer;
import ChavesWeb.Chaves.services.ChavesPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chavesplayers")
public class ChavesPlayerController {

    @Autowired
    private ChavesPlayerService chavesPlayerService;

    @GetMapping
    public List<ChavesPlayer> getAllChavesPlayers() {
        return chavesPlayerService.getAllChavesPlayers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChavesPlayer> getChavesPlayerById(@PathVariable Integer id) {
        return chavesPlayerService.getChavesPlayerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ChavesPlayer createChavesPlayer(@RequestBody ChavesPlayer chavesPlayer) {
        return chavesPlayerService.createChavesPlayer(chavesPlayer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChavesPlayer> updateChavesPlayer(@PathVariable Integer id, @RequestBody ChavesPlayer chavesPlayerDetails) {
        return chavesPlayerService.getChavesPlayerById(id)
                .map(chavesPlayer -> ResponseEntity.ok(chavesPlayerService.updateChavesPlayer(id, chavesPlayerDetails)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChavesPlayer(@PathVariable Integer id) {
        if (chavesPlayerService.getChavesPlayerById(id).isPresent()) {
            chavesPlayerService.deleteChavesPlayer(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
