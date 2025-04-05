package me.itsvaske.coffeeshopvegait.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.itsvaske.coffeeshopvegait.model.Drink;
import me.itsvaske.coffeeshopvegait.model.request.DrinkDTO;
import me.itsvaske.coffeeshopvegait.repo.DrinkRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository repository;

    @Override
    @Transactional
    public Drink add(DrinkDTO drink) {

        var newDrink = new Drink();

        newDrink.setName(drink.getName());
        newDrink.setCoffeeRequired(drink.getCoffeeRequired());
        newDrink.setTimeRequired(drink.getTimeRequired());
        newDrink.setPrice(drink.getPrice());

        return repository.save(newDrink);
    }

    @Override
    @Transactional
    public Drink modify(Drink drink) {

        var existingDrink = repository.findById(drink.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested drink cannot be found."));

        existingDrink.setName(drink.getName());
        existingDrink.setTimeRequired(drink.getTimeRequired());
        existingDrink.setCoffeeRequired(drink.getCoffeeRequired());
        existingDrink.setPrice(drink.getPrice());

        return repository.save(existingDrink);
    }

    @Override
    public void remove(Drink drink) {

        var existingDrink = repository.findById(drink.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested drink cannot be found."));

        repository.delete(existingDrink);
    }

    @Override
    public double price(Long id) {

        var existingDrink = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested drink cannot be found."));

        return existingDrink.getPrice();
    }

    @Override
    public byte[] image(Long id) {

        var existingDrink = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested drink cannot be found."));

        return existingDrink.getImage();
    }

    @Override
    public int coffeeRequired(Long id) {

        var existingDrink = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested drink cannot be found."));

        return existingDrink.getCoffeeRequired();
    }

    @Override
    public int timeToPrepare(Long id) {

        var existingDrink = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested drink cannot be found."));

        return existingDrink.getTimeRequired();
    }
}
