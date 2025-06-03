package ChavesWeb.Chaves.services;

import ChavesWeb.Chaves.models.Encomenda;
import ChavesWeb.Chaves.repositories.EncomendaProdutoRepository;
import ChavesWeb.Chaves.repositories.EncomendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncomendaService {

    private final EncomendaRepository encomendaRepository;
    private final EncomendaProdutoRepository encomendaProdutoRepository;

    public EncomendaService(EncomendaRepository encomendaRepository, EncomendaProdutoRepository encomendaProdutoRepository) {
        this.encomendaRepository = encomendaRepository;
        this.encomendaProdutoRepository = encomendaProdutoRepository;
    }

    public List<Encomenda> getAllEncomendas() {
        return encomendaRepository.findAll();
    }

    public Optional<Encomenda> getEncomendaById(Integer id) {
        return encomendaRepository.findById(id);
    }

    public Encomenda createEncomenda(Encomenda encomenda) {
        Encomenda saved = encomendaRepository.save(encomenda);
        encomendaProdutoRepository.saveAll(encomenda.getProdutos());
        return saved;
    }

    public Encomenda updateEncomenda(Integer id, Encomenda updatedEncomenda) {
        return encomendaRepository.findById(id)
                .map(e -> {
                    e.setNome(updatedEncomenda.getNome());
                    e.setEmail(updatedEncomenda.getEmail());
                    e.setEncDate(updatedEncomenda.getEncDate());
                    e.setEncAdress(updatedEncomenda.getEncAdress());
                    return encomendaRepository.save(e);
                })
                .orElseThrow(() -> new RuntimeException("Encomenda not found"));
    }

    public void deleteEncomenda(Integer id) {
        encomendaRepository.deleteById(id);
    }
}