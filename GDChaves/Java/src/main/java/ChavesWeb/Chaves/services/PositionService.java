package ChavesWeb.Chaves.services;

import ChavesWeb.Chaves.models.Position;
import ChavesWeb.Chaves.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public Optional<Position> getPositionById(Integer id) {
        return positionRepository.findById(id);
    }

    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }

    public Position updatePosition(Integer id, Position positionDetails) {
        return positionRepository.findById(id)
            .map(position -> {
                position.setName(positionDetails.getName());
                return positionRepository.save(position);
            })
            .orElseThrow(() -> new RuntimeException("Position not found with id " + id));
    }

    public void deletePosition(Integer id) {
        if (positionRepository.existsById(id)) {
            positionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Position not found with id " + id);
        }
    }
}
