package ChavesWeb.Chaves.services;

import ChavesWeb.Chaves.models.Produto;
import ChavesWeb.Chaves.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoById(Integer id) {
        return produtoRepository.findById(id);
    }

    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Integer id, Produto updatedProduto) {
        return produtoRepository.findById(id)
                .map(p -> {
                    p.setProdName(updatedProduto.getProdName());
                    p.setProdFoto(updatedProduto.getProdFoto());
                    p.setProdDesc(updatedProduto.getProdDesc());
                    return produtoRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Produto not found"));
    }

    public void deleteProduto(Integer id) {
        produtoRepository.deleteById(id);
    }
}