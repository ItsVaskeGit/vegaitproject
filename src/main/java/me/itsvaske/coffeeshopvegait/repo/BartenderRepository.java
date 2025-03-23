package me.itsvaske.coffeeshopvegait.repo;

import me.itsvaske.coffeeshopvegait.model.Bartender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BartenderRepository extends JpaRepository<Bartender, Long> {
}
