package ChavesWeb.Chaves.services;

import ChavesWeb.Chaves.models.EncomendaProduto;
import ChavesWeb.Chaves.repositories.EncomendaProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncomendaProdutoService {

    private final EncomendaProdutoRepository encomendaProdutoRepository;

    public EncomendaProdutoService(EncomendaProdutoRepository encomendaProdutoRepository) {
        this.encomendaProdutoRepository = encomendaProdutoRepository;
    }

    public List<EncomendaProduto> getAll() {
        return encomendaProdutoRepository.findAll();
    }

    public Optional<EncomendaProduto> getById(Integer id) {
        return encomendaProdutoRepository.findById(id);
    }

    public EncomendaProduto create(EncomendaProduto item) {
        return encomendaProdutoRepository.save(item);
    }

    public void delete(Integer id) {
        encomendaProdutoRepository.deleteById(id);
    }
}