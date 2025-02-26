package me.itsvaske.coffeeshopvegait.repo;

import me.itsvaske.coffeeshopvegait.model.EspressoMachine;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspressoMachineRepository extends CrudRepository<EspressoMachine, Long> {

    @Query("update EspressoMachine e SET e.coffeeLeft = 300")
    @EventListener(ApplicationReadyEvent.class)
    void resetCoffee();

}
