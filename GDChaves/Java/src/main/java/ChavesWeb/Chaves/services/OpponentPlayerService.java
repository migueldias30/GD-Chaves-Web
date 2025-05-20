package ChavesWeb.Chaves.services;

import ChavesWeb.Chaves.models.*;
import ChavesWeb.Chaves.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpponentPlayerService {

    @Autowired
    private OpponentPlayerRepository opponentPlayerRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private OpponentRepository opponentRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    public List<OpponentPlayer> getAllOpponentPlayers() {
        return opponentPlayerRepository.findAll();
    }

    public Optional<OpponentPlayer> getOpponentPlayerById(Integer id) {
        return opponentPlayerRepository.findById(id);
    }

    public OpponentPlayer createOpponentPlayer(OpponentPlayer opponentPlayer) {
        Integer playerId = opponentPlayer.getPlayer().getId();
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found with id " + playerId));
        opponentPlayer.setPlayer(player);

        Integer opponentId = opponentPlayer.getOpponent().getId();
        Opponent opponent = opponentRepository.findById(opponentId)
                .orElseThrow(() -> new RuntimeException("Opponent not found with id " + opponentId));
        opponentPlayer.setOpponent(opponent);

        Integer positionId = opponentPlayer.getPosition().getId();
        Position position = positionRepository.findById(positionId)
                .orElseThrow(() -> new RuntimeException("Position not found with id " + positionId));
        opponentPlayer.setPosition(position);

        Long seasonId = opponentPlayer.getSeason().getId();
        Season season = seasonRepository.findById(seasonId)
                .orElseThrow(() -> new RuntimeException("Season not found with id " + seasonId));
        opponentPlayer.setSeason(season);

        return opponentPlayerRepository.save(opponentPlayer);
    }

    public OpponentPlayer updateOpponentPlayer(Integer id, OpponentPlayer opponentPlayerDetails) {
        return opponentPlayerRepository.findById(id)
                .map(opponentPlayer -> {
                    Integer playerId = opponentPlayerDetails.getPlayer().getId();
                    Player player = playerRepository.findById(playerId)
                            .orElseThrow(() -> new RuntimeException("Player not found with id " + playerId));
                    opponentPlayer.setPlayer(player);

                    Integer opponentId = opponentPlayerDetails.getOpponent().getId();
                    Opponent opponent = opponentRepository.findById(opponentId)
                            .orElseThrow(() -> new RuntimeException("Opponent not found with id " + opponentId));
                    opponentPlayer.setOpponent(opponent);

                    Integer positionId = opponentPlayerDetails.getPosition().getId();
                    Position position = positionRepository.findById(positionId)
                            .orElseThrow(() -> new RuntimeException("Position not found with id " + positionId));
                    opponentPlayer.setPosition(position);

                    Long seasonId = opponentPlayerDetails.getSeason().getId();
                    Season season = seasonRepository.findById(seasonId)
                            .orElseThrow(() -> new RuntimeException("Season not found with id " + seasonId));
                    opponentPlayer.setSeason(season);

                    return opponentPlayerRepository.save(opponentPlayer);
                })
                .orElseThrow(() -> new RuntimeException("OpponentPlayer not found with id " + id));
    }

    public void deleteOpponentPlayer(Integer id) {
        if (!opponentPlayerRepository.existsById(id)) {
            throw new RuntimeException("OpponentPlayer not found with id " + id);
        }
        opponentPlayerRepository.deleteById(id);
    }
}
