package de.htwberlin.webtech2.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AufgabeRepository extends JpaRepository<AufgabeEntity, Long> {

    List<AufgabeEntity> findAllByTask (String task);
}
