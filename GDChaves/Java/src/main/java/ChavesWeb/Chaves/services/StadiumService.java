package ChavesWeb.Chaves.services;

import ChavesWeb.Chaves.models.Stadium;
import ChavesWeb.Chaves.repositories.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StadiumService {

    @Autowired
    private StadiumRepository stadiumRepository;

    public List<Stadium> getAllStadiums() {
        return stadiumRepository.findAll();
    }

    public Optional<Stadium> getStadiumById(Integer id) {
        return stadiumRepository.findById(id);
    }

    public Stadium createStadium(Stadium stadium) {
        return stadiumRepository.save(stadium);
    }

    public Stadium updateStadium(Integer id, Stadium stadiumDetails) {
        return stadiumRepository.findById(id)
            .map(stadium -> {
                stadium.setName(stadiumDetails.getName());
                stadium.setAddress(stadiumDetails.getAddress());
                stadium.setPhoto(stadiumDetails.getPhoto());
                return stadiumRepository.save(stadium);
            })
            .orElseThrow(() -> new RuntimeException("Stadium not found with id " + id));
    }

    public void deleteStadium(Integer id) {
        if (!stadiumRepository.existsById(id)) {
            throw new RuntimeException("Stadium not found with id " + id);
        }
        stadiumRepository.deleteById(id);
    }
}
