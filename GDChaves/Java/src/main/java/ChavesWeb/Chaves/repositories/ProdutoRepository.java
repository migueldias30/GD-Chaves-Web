package ChavesWeb.Chaves.repositories;

import ChavesWeb.Chaves.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}