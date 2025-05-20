package ChavesWeb.Chaves.controllers;

import ChavesWeb.Chaves.models.Opponent;
import ChavesWeb.Chaves.services.OpponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/opponents")
public class OpponentController {

    @Autowired
    private OpponentService opponentService;

    @GetMapping
    public List<Opponent> getAllOpponents() {
        return opponentService.getAllOpponents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Opponent> getOpponentById(@PathVariable Integer id) {
        return opponentService.getOpponentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Opponent createOpponent(@RequestBody Opponent opponent) {
        return opponentService.createOpponent(opponent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Opponent> updateOpponent(@PathVariable Integer id, @RequestBody Opponent opponentDetails) {
        return opponentService.updateOpponent(id, opponentDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOpponent(@PathVariable Integer id) {
        if (opponentService.deleteOpponent(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
