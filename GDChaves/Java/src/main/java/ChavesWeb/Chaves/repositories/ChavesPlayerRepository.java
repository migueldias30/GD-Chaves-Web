package ChavesWeb.Chaves.repositories;

import ChavesWeb.Chaves.models.ChavesPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChavesPlayerRepository extends JpaRepository<ChavesPlayer, Integer> {
}
