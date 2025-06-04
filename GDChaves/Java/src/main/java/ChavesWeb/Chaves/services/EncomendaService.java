package ChavesWeb.Chaves.services;

import ChavesWeb.Chaves.models.Encomenda;
import ChavesWeb.Chaves.repositories.EncomendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncomendaService {

    private final EncomendaRepository encomendaRepository;

    public EncomendaService(EncomendaRepository encomendaRepository) {
        this.encomendaRepository = encomendaRepository;
    }

    public List<Encomenda> getAllEncomendas() {
        return encomendaRepository.findAll();
    }

    public Encomenda createEncomenda(Encomenda encomenda) {
        if (encomenda.getProdutos() != null) {
            encomenda.getProdutos().forEach(p -> p.setEncomenda(encomenda));
        }

        return encomendaRepository.save(encomenda);
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
