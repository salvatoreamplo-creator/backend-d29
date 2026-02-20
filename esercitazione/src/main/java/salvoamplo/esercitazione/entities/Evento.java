package salvoamplo.esercitazione.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titolo;
    private String descrizione;
    private LocalDate data;
    private String location;
    private int postiDisponibili;

    @ManyToOne
    @JoinColumn(name = "organizzatore_id", nullable = false)
    private User organizzatore;
}