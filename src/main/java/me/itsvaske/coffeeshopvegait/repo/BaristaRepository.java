package me.itsvaske.coffeeshopvegait.repo;

import me.itsvaske.coffeeshopvegait.model.Barista;
import me.itsvaske.coffeeshopvegait.model.CoffeeShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaristaRepository extends JpaRepository<Barista, Long> {

    List<Barista> getByCoffeeShop(CoffeeShop coffeeShop);
}
