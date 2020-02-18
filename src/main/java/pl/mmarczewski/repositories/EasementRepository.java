package pl.mmarczewski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmarczewski.model.Easement;

public interface EasementRepository extends JpaRepository<Easement, Long> {
}
