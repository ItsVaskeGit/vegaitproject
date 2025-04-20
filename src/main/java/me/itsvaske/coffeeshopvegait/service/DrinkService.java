package me.itsvaske.coffeeshopvegait.service;

import me.itsvaske.coffeeshopvegait.model.Drink;
import me.itsvaske.coffeeshopvegait.model.request.DrinkDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DrinkService {

    ResponseEntity<Drink> add(DrinkDTO drink);

    ResponseEntity<Drink> modify(Drink drink);

    void remove(Drink drink);

    ResponseEntity<Double> price(Long id);

    ResponseEntity<byte[]> image(Long id);

    ResponseEntity<Integer> coffeeRequired(Long id);

    ResponseEntity<Integer> timeToPrepare(Long id);

    List<Drink> getAll();
}
