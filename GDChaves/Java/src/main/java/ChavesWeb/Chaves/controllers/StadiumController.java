package ChavesWeb.Chaves.controllers;

import ChavesWeb.Chaves.models.Stadium;
import ChavesWeb.Chaves.services.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stadiums")
public class StadiumController {

    @Autowired
    private StadiumService stadiumService;

    @GetMapping
    public List<Stadium> getAllStadiums() {
        return stadiumService.getAllStadiums();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stadium> getStadiumById(@PathVariable Integer id) {
        return stadiumService.getStadiumById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Stadium createStadium(@RequestBody Stadium stadium) {
        return stadiumService.createStadium(stadium);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stadium> updateStadium(@PathVariable Integer id, @RequestBody Stadium stadiumDetails) {
        return stadiumService.getStadiumById(id)
                .map(stadium -> ResponseEntity.ok(stadiumService.updateStadium(id, stadiumDetails)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStadium(@PathVariable Integer id) {
        if (stadiumService.getStadiumById(id).isPresent()) {
            stadiumService.deleteStadium(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
