package me.itsvaske.coffeeshopvegait.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.itsvaske.coffeeshopvegait.model.Barista;
import me.itsvaske.coffeeshopvegait.model.EspressoMachine;
import me.itsvaske.coffeeshopvegait.model.request.BaristaDTO;
import me.itsvaske.coffeeshopvegait.repo.BaristaRepository;
import me.itsvaske.coffeeshopvegait.repo.CoffeeShopRepository;
import me.itsvaske.coffeeshopvegait.repo.EspressoMachineRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CoffeeShopServiceImpl implements CoffeeShopService {

    private final CoffeeShopRepository coffeeShopRepository;
    private final BaristaRepository baristaRepository;
    private final EspressoMachineRepository espressoMachineRepository;

    @Override
    @Transactional
    public ResponseEntity<Barista> addBarista(BaristaDTO barista, Long coffeeShopId) {

        var coffeeShop = coffeeShopRepository.findById(coffeeShopId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Specified coffee shop was not found."));

        var baristas = baristaRepository.getByCoffeeShop(coffeeShop);

        if(baristas.size() < 2) {
            var newBarista = new Barista();

            newBarista.setName(barista.getName());
            newBarista.setCoffeeShop(coffeeShop);

            return new ResponseEntity<>(baristaRepository.save(newBarista), HttpStatus.OK);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot add more than 3 baristas to one coffee shop.");
        }

    }

    @Override
    @Transactional
    public ResponseEntity<EspressoMachine> assignMachine(Long baristaId) {

        var barista = baristaRepository.findById(baristaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if(barista.getEspressoMachine() == null) {
            var machine = new EspressoMachine();

            machine.setCoffeeLeft(300);
            machine.setReady(true);
            barista.setEspressoMachine(machine);

            return new ResponseEntity<>(espressoMachineRepository.save(machine), HttpStatus.OK);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Barista already has an assigned espresso machine.");
        }

    }
}
