package me.itsvaske.coffeeshopvegait.repo;

import me.itsvaske.coffeeshopvegait.model.EspressoMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EspressoMachineRepository extends JpaRepository<EspressoMachine, Long> {

    @Query("update EspressoMachine e SET e.coffeeLeft = 300, e.ready = true")
    void resetCoffee();

    @Query("update EspressoMachine e SET e.coffeeLeft = 300, e.ready = true WHERE e.id = :#{#id}")
    void refill(@Param("id") Long espressoMachineId);
}
