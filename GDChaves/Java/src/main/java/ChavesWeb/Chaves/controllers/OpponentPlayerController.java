package ChavesWeb.Chaves.controllers;

import ChavesWeb.Chaves.models.OpponentPlayer;
import ChavesWeb.Chaves.services.OpponentPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/opponent-players")
public class OpponentPlayerController {

    @Autowired
    private OpponentPlayerService opponentPlayerService;

    @GetMapping
    public List<OpponentPlayer> getAllOpponentPlayers() {
        return opponentPlayerService.getAllOpponentPlayers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpponentPlayer> getOpponentPlayerById(@PathVariable Integer id) {
        return opponentPlayerService.getOpponentPlayerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OpponentPlayer createOpponentPlayer(@RequestBody OpponentPlayer opponentPlayer) {
        return opponentPlayerService.createOpponentPlayer(opponentPlayer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OpponentPlayer> updateOpponentPlayer(@PathVariable Integer id, @RequestBody OpponentPlayer opponentPlayerDetails) {
        return opponentPlayerService.getOpponentPlayerById(id)
                .map(opponentPlayer -> ResponseEntity.ok(opponentPlayerService.updateOpponentPlayer(id, opponentPlayerDetails)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOpponentPlayer(@PathVariable Integer id) {
        if (opponentPlayerService.getOpponentPlayerById(id).isPresent()) {
            opponentPlayerService.deleteOpponentPlayer(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
