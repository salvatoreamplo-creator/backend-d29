package salvoamplo.esercitazione.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import salvoamplo.esercitazione.entities.Evento;
import salvoamplo.esercitazione.entities.User;
import salvoamplo.esercitazione.repositories.EventoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventoService {

    private final EventoRepository eventoRepository;

    public List<Evento> findAll() {
        return eventoRepository.findAll();
    }

    public Evento creaEvento(Evento evento, User organizzatore) {
        evento.setOrganizzatore(organizzatore);
        return eventoRepository.save(evento);
    }

    public Evento modificaEvento(Long id, Evento nuovo, User user) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento non trovato"));

        if (!evento.getOrganizzatore().getId().equals(user.getId())) {
            throw new RuntimeException("Non autorizzato");
        }

        evento.setTitolo(nuovo.getTitolo());
        evento.setDescrizione(nuovo.getDescrizione());
        evento.setData(nuovo.getData());
        evento.setLocation(nuovo.getLocation());
        evento.setPostiDisponibili(nuovo.getPostiDisponibili());

        return eventoRepository.save(evento);
    }
}
