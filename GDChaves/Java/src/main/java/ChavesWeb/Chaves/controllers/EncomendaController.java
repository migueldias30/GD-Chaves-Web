package ChavesWeb.Chaves.controllers;

import ChavesWeb.Chaves.models.Encomenda;
import ChavesWeb.Chaves.services.EncomendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/encomendas")
public class EncomendaController {

    private final EncomendaService encomendaService;

    public EncomendaController(EncomendaService encomendaService) {
        this.encomendaService = encomendaService;
    }

    @GetMapping
    public List<Encomenda> getAll() {
        return encomendaService.getAllEncomendas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Encomenda> getById(@PathVariable Integer id) {
        return encomendaService.getEncomendaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Encomenda create(@RequestBody Encomenda encomenda) {
        return encomendaService.createEncomenda(encomenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Encomenda> update(@PathVariable Integer id, @RequestBody Encomenda encomenda) {
        try {
            return ResponseEntity.ok(encomendaService.updateEncomenda(id, encomenda));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        encomendaService.deleteEncomenda(id);
        return ResponseEntity.noContent().build();
    }
}