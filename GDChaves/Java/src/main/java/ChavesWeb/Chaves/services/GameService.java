package ChavesWeb.Chaves.services;

import ChavesWeb.Chaves.models.*;
import ChavesWeb.Chaves.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private StadiumRepository stadiumRepository;

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private OpponentRepository opponentRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(Integer id) {
        return gameRepository.findById(id);
    }

    public Game createGame(Game game) {
        if (game.getStadium() != null) {
            Integer stadiumId = game.getStadium().getId();
            Stadium stadium = stadiumRepository.findById(stadiumId)
                    .orElseThrow(() -> new RuntimeException("Stadium not found with id " + stadiumId));
            game.setStadium(stadium);
        }

        Integer competitionId = game.getCompetition().getId();
        Competition competition = competitionRepository.findById(competitionId)
                .orElseThrow(() -> new RuntimeException("Competition not found with id " + competitionId));
        game.setCompetition(competition);

        if (game.getOpponent() != null) {
            Integer opponentId = game.getOpponent().getId();
            Opponent opponent = opponentRepository.findById(opponentId)
                    .orElseThrow(() -> new RuntimeException("Opponent not found with id " + opponentId));
            game.setOpponent(opponent);
        }

        return gameRepository.save(game);
    }

    public Game updateGame(Integer id, Game gameDetails) {
        return gameRepository.findById(id)
                .map(game -> {
                    game.setName(gameDetails.getName());
                    game.setDate(gameDetails.getDate());

                    if (gameDetails.getStadium() != null) {
                        Integer stadiumId = gameDetails.getStadium().getId();
                        Stadium stadium = stadiumRepository.findById(stadiumId)
                                .orElseThrow(() -> new RuntimeException("Stadium not found with id " + stadiumId));
                        game.setStadium(stadium);
                    }

                    Integer competitionId = gameDetails.getCompetition().getId();
                    Competition competition = competitionRepository.findById(competitionId)
                            .orElseThrow(() -> new RuntimeException("Competition not found with id " + competitionId));
                    game.setCompetition(competition);

                    if (gameDetails.getOpponent() != null) {
                        Integer opponentId = gameDetails.getOpponent().getId();
                        Opponent opponent = opponentRepository.findById(opponentId)
                                .orElseThrow(() -> new RuntimeException("Opponent not found with id " + opponentId));
                        game.setOpponent(opponent);
                    }

                    return gameRepository.save(game);
                })
                .orElseThrow(() -> new RuntimeException("Game not found with id " + id));
    }

    public void deleteGame(Integer id) {
        if (!gameRepository.existsById(id)) {
            throw new RuntimeException("Game not found with id " + id);
        }
        gameRepository.deleteById(id);
    }
}
