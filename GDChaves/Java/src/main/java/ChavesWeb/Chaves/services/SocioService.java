package ChavesWeb.Chaves.services;

import ChavesWeb.Chaves.models.Socio;
import ChavesWeb.Chaves.repositories.SocioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocioService {

    private final SocioRepository socioRepository;

    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    public List<Socio> getAllSocios() {
        return socioRepository.findAll();
    }

    public Optional<Socio> getSocioById(Integer id) {
        return socioRepository.findById(id);
    }

    public Socio createSocio(Socio socio) {
        return socioRepository.save(socio);
    }

    public Socio updateSocio(Integer id, Socio updatedSocio) {
        return socioRepository.findById(id)
                .map(s -> {
                    s.setSocioName(updatedSocio.getSocioName());
                    s.setSocioNum(updatedSocio.getSocioNum());
                    s.setSocioEmail(updatedSocio.getSocioEmail());
                    s.setSocioBdate(updatedSocio.getSocioBdate());
                    return socioRepository.save(s);
                })
                .orElseThrow(() -> new RuntimeException("Socio not found"));
    }

    public void deleteSocio(Integer id) {
        socioRepository.deleteById(id);
    }
}