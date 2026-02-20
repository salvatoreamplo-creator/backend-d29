package salvoamplo.esercitazione.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salvoamplo.esercitazione.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}