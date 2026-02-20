package salvoamplo.esercitazione.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import salvoamplo.esercitazione.entities.Evento;
import salvoamplo.esercitazione.entities.Prenotazione;
import salvoamplo.esercitazione.entities.User;
import salvoamplo.esercitazione.repositories.EventoRepository;
import salvoamplo.esercitazione.repositories.PrenotazioneRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PrenotazioneService {

    private final EventoRepository eventoRepository;
    private final PrenotazioneRepository prenotazioneRepository;

    @Transactional
    public void prenota(Long eventoId, User user) {

        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new RuntimeException("Evento non trovato"));

        if (evento.getPostiDisponibili() <= 0)
            throw new RuntimeException("Posti esauriti");

        if (prenotazioneRepository.existsByUserAndEvento(user, evento))
            throw new RuntimeException("Già prenotato");

        evento.setPostiDisponibili(evento.getPostiDisponibili() - 1);

        Prenotazione p = new Prenotazione();
        p.setUser(user);
        p.setEvento(evento);
        p.setDataPrenotazione(LocalDateTime.now());

        prenotazioneRepository.save(p);
    }
}
