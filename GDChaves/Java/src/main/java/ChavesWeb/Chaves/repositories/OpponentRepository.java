package ChavesWeb.Chaves.repositories;

import ChavesWeb.Chaves.models.Opponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpponentRepository extends JpaRepository<Opponent, Integer> {
}
