package salvoamplo.esercitazione.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salvoamplo.esercitazione.entities.Evento;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByOrganizzatoreId(Long id);
}
