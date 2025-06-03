package ChavesWeb.Chaves.controllers;

import ChavesWeb.Chaves.dto.EncomendaDto;
import ChavesWeb.Chaves.models.Encomenda;
import ChavesWeb.Chaves.models.EncomendaProduto;
import ChavesWeb.Chaves.models.User;
import ChavesWeb.Chaves.services.EncomendaService;
import ChavesWeb.Chaves.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/encomendas")
public class EncomendaController {

    private final EncomendaService encomendaService;
    private final UserService userService;

    public EncomendaController(EncomendaService encomendaService, UserService userService) {
        this.encomendaService = encomendaService;
        this.userService = userService;
    }

    @GetMapping
    public List<Encomenda> getAll() {
        return encomendaService.getAllEncomendas();
    }

    @PostMapping
    public ResponseEntity<Encomenda> create(@RequestBody EncomendaDto request) {
        Encomenda encomenda = new Encomenda();
        encomenda.setNome(request.nome);
        encomenda.setEmail(request.email);
        encomenda.setEncAdress(request.endereco);
        encomenda.setEncDate(LocalDate.now());

        if (request.userId != null) {
            User user = userService.getUserById(Long.valueOf(request.userId));
            if (user != null) {
                encomenda.setUser(user);
            }
        }

        List<EncomendaProduto> produtos = request.produtos.stream().map(p -> {
            EncomendaProduto ep = new EncomendaProduto();
            ep.setNome(p.nome);
            ep.setPreco(p.preco);
            ep.setProdutoId(p.id);
            ep.setEncomenda(encomenda);
            return ep;
        }).collect(Collectors.toList());

        encomenda.setProdutos(produtos);
        return ResponseEntity.ok(encomendaService.createEncomenda(encomenda));
    }
}