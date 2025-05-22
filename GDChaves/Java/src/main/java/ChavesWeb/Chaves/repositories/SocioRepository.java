package ChavesWeb.Chaves.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ChavesWeb.Chaves.models.Socio;

public interface SocioRepository extends JpaRepository<Socio, Integer> {
}