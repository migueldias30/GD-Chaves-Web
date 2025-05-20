package ChavesWeb.Chaves.services;

import ChavesWeb.Chaves.models.Opponent;
import ChavesWeb.Chaves.repositories.OpponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpponentService {

    @Autowired
    private OpponentRepository opponentRepository;

    public List<Opponent> getAllOpponents() {
        return opponentRepository.findAll();
    }

    public Optional<Opponent> getOpponentById(Integer id) {
        return opponentRepository.findById(id);
    }

    public Opponent createOpponent(Opponent opponent) {
        return opponentRepository.save(opponent);
    }

    public Optional<Opponent> updateOpponent(Integer id, Opponent opponentDetails) {
        return opponentRepository.findById(id).map(opponent -> {
            opponent.setName(opponentDetails.getName());
            return opponentRepository.save(opponent);
        });
    }

    public boolean deleteOpponent(Integer id) {
        if (opponentRepository.existsById(id)) {
            opponentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
