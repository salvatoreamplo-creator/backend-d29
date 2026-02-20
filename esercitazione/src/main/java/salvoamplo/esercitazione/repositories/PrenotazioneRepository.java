package salvoamplo.esercitazione.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salvoamplo.esercitazione.entities.Evento;
import salvoamplo.esercitazione.entities.Prenotazione;
import salvoamplo.esercitazione.entities.User;

import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByUserAndEvento(User user, Evento evento);

    List<Prenotazione> findByUser(User user);
}