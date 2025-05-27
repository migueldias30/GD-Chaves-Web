package ChavesWeb.Chaves.controllers;

import ChavesWeb.Chaves.models.EncomendaProduto;
import ChavesWeb.Chaves.services.EncomendaProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/encomendasprodutos")
public class EncomendaProdutoController {

    private final EncomendaProdutoService service;

    public EncomendaProdutoController(EncomendaProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<EncomendaProduto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncomendaProduto> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EncomendaProduto create(@RequestBody EncomendaProduto item) {
        return service.create(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EncomendaProduto> update(@PathVariable Integer id, @RequestBody EncomendaProduto item) {
        try {
            return ResponseEntity.ok(service.update(id, item));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
