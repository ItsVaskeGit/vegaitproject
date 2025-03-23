package me.itsvaske.coffeeshopvegait.repo;

import me.itsvaske.coffeeshopvegait.model.EspressoMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EspressoMachineRepository extends JpaRepository<EspressoMachine, Long> {

    @Query("update EspressoMachine e SET e.coffeeLeft = 300")
//    @EventListener(ApplicationReadyEvent.class)
    void resetCoffee();

}
