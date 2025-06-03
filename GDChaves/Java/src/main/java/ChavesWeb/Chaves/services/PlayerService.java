package ChavesWeb.Chaves.services;

import ChavesWeb.Chaves.models.Player;
import ChavesWeb.Chaves.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Integer id) {
        return playerRepository.findById(id);
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Integer id, Player playerDetails) {
        return playerRepository.findById(id)
                .map(player -> {
                    player.setName(playerDetails.getName());
                    player.setBirthDate(playerDetails.getBirthDate());
                    player.setYears(playerDetails.getYears());
                    player.setNumber(playerDetails.getNumber());
                    player.setNationality(playerDetails.getNationality());
                    player.setPhoto(playerDetails.getPhoto());
                    return playerRepository.save(player);
                })
                .orElseThrow(() -> new RuntimeException("Player not found with id " + id));
    }

    public void deletePlayer(Integer id) {
        if (!playerRepository.existsById(id)) {
            throw new RuntimeException("Player not found with id " + id);
        }
        playerRepository.deleteById(id);
    }

    public List<Player> getAllPlayersWithPosition() {
        return playerRepository.findAll();
    }
}
