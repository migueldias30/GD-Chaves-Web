package ChavesWeb.Chaves.services;

import ChavesWeb.Chaves.models.Encomenda;
import ChavesWeb.Chaves.repositories.EncomendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncomendaService {

    private final EncomendaRepository encomendaRepository;

    public EncomendaService(EncomendaRepository encomendaRepository) {
        this.encomendaRepository = encomendaRepository;
    }

    public List<Encomenda> getAllEncomendas() {
        return encomendaRepository.findAll();
    }

    public Optional<Encomenda> getEncomendaById(Integer id) {
        return encomendaRepository.findById(id);
    }

    public Encomenda createEncomenda(Encomenda encomenda) {
        return encomendaRepository.save(encomenda);
    }

    public Encomenda updateEncomenda(Integer id, Encomenda updatedEncomenda) {
        return encomendaRepository.findById(id)
                .map(e -> {
                    e.setEncSocioId(updatedEncomenda.getEncSocioId());
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