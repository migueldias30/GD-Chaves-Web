package ChavesWeb.Chaves.repositories;

import ChavesWeb.Chaves.models.OpponentPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpponentPlayerRepository extends JpaRepository<OpponentPlayer, Integer> {
}
