package ChavesWeb.Chaves.services;

import ChavesWeb.Chaves.models.ChavesPlayer;
import ChavesWeb.Chaves.models.Player;
import ChavesWeb.Chaves.models.Position;
import ChavesWeb.Chaves.models.Season;
import ChavesWeb.Chaves.repositories.ChavesPlayerRepository;
import ChavesWeb.Chaves.repositories.PlayerRepository;
import ChavesWeb.Chaves.repositories.PositionRepository;
import ChavesWeb.Chaves.repositories.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChavesPlayerService {

    @Autowired
    private ChavesPlayerRepository chavesPlayerRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PositionRepository positionRepository;

    public List<ChavesPlayer> getAllChavesPlayers() {
        return chavesPlayerRepository.findAll();
    }

    public Optional<ChavesPlayer> getChavesPlayerById(Integer id) {
        return chavesPlayerRepository.findById(id);
    }

    public ChavesPlayer createChavesPlayer(ChavesPlayer chavesPlayer) {
        Season season = seasonRepository.findById(chavesPlayer.getSeason().getId())
                .orElseThrow(() -> new RuntimeException("Season not found with id " + chavesPlayer.getSeason().getId()));
        Player player = playerRepository.findById(chavesPlayer.getPlayer().getId())
                .orElseThrow(() -> new RuntimeException("Player not found with id " + chavesPlayer.getPlayer().getId()));
        Position position = positionRepository.findById(chavesPlayer.getPosition().getId())
                .orElseThrow(() -> new RuntimeException("Position not found with id " + chavesPlayer.getPosition().getId()));

        chavesPlayer.setSeason(season);
        chavesPlayer.setPlayer(player);
        chavesPlayer.setPosition(position);
        return chavesPlayerRepository.save(chavesPlayer);
    }

    public ChavesPlayer updateChavesPlayer(Integer id, ChavesPlayer chavesPlayerDetails) {
        return chavesPlayerRepository.findById(id)
                .map(chavesPlayer -> {
                    Season season = seasonRepository.findById(chavesPlayerDetails.getSeason().getId())
                            .orElseThrow(() -> new RuntimeException("Season not found with id " + chavesPlayerDetails.getSeason().getId()));
                    Player player = playerRepository.findById(chavesPlayerDetails.getPlayer().getId())
                            .orElseThrow(() -> new RuntimeException("Player not found with id " + chavesPlayerDetails.getPlayer().getId()));
                    Position position = positionRepository.findById(chavesPlayerDetails.getPosition().getId())
                            .orElseThrow(() -> new RuntimeException("Position not found with id " + chavesPlayerDetails.getPosition().getId()));

                    chavesPlayer.setSeason(season);
                    chavesPlayer.setPlayer(player);
                    chavesPlayer.setPosition(position);
                    return chavesPlayerRepository.save(chavesPlayer);
                })
                .orElseThrow(() -> new RuntimeException("ChavesPlayer not found with id " + id));
    }

    public void deleteChavesPlayer(Integer id) {
        chavesPlayerRepository.deleteById(id);
    }
}
