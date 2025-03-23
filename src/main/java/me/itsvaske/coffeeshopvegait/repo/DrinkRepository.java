package me.itsvaske.coffeeshopvegait.repo;

import me.itsvaske.coffeeshopvegait.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
}
