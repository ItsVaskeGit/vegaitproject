package me.itsvaske.coffeeshopvegait.service;

import me.itsvaske.coffeeshopvegait.model.Drink;
import me.itsvaske.coffeeshopvegait.model.request.DrinkDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DrinkService {

    Drink add(DrinkDTO drink);

    Drink modify(Drink drink);

    void remove(Drink drink);

    double price(Long id);

    byte[] image(Long id);

    int coffeeRequired(Long id);

    int timeToPrepare(Long id);
}
