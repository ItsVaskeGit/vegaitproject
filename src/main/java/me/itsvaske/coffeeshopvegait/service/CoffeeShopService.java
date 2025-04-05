package me.itsvaske.coffeeshopvegait.service;

import me.itsvaske.coffeeshopvegait.model.Barista;
import me.itsvaske.coffeeshopvegait.model.EspressoMachine;
import me.itsvaske.coffeeshopvegait.model.request.BaristaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CoffeeShopService {

    ResponseEntity<Barista> addBarista(BaristaDTO barista, Long coffeeShop);

    ResponseEntity<EspressoMachine> assignMachine(Long baristaId);
}
