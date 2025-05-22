package ChavesWeb.Chaves.controllers;

import ChavesWeb.Chaves.models.Socio;
import ChavesWeb.Chaves.services.SocioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    private final SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    @GetMapping
    public List<Socio> getAll() {
        return socioService.getAllSocios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Socio> getById(@PathVariable Integer id) {
        return socioService.getSocioById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Socio create(@RequestBody Socio socio) {
        return socioService.createSocio(socio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Socio> update(@PathVariable Integer id, @RequestBody Socio socio) {
        try {
            return ResponseEntity.ok(socioService.updateSocio(id, socio));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        socioService.deleteSocio(id);
        return ResponseEntity.noContent().build();
    }
}