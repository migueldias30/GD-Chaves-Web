package ChavesWeb.Chaves.services;

import ChavesWeb.Chaves.models.Competition;
import ChavesWeb.Chaves.repositories.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    public Optional<Competition> getCompetitionById(Integer id) {
        return competitionRepository.findById(id);
    }

    public Competition createCompetition(Competition competition) {
        return competitionRepository.save(competition);
    }

    public Optional<Competition> updateCompetition(Integer id, Competition competitionDetails) {
        return Optional.ofNullable(competitionRepository.findById(id)
                .map(existingCompetition -> {
                    existingCompetition.setName(competitionDetails.getName());
                    return competitionRepository.save(existingCompetition);
                })
                .orElseThrow(() -> new RuntimeException("Competition not found with id " + id)));
    }

    public void deleteCompetition(Integer id) {
        if (!competitionRepository.existsById(id)) {
            throw new RuntimeException("Competition not found with id " + id);
        }
        competitionRepository.deleteById(id);
    }
}
