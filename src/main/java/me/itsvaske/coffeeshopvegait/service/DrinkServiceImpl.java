package me.itsvaske.coffeeshopvegait.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.itsvaske.coffeeshopvegait.model.Drink;
import me.itsvaske.coffeeshopvegait.model.request.DrinkDTO;
import me.itsvaske.coffeeshopvegait.repo.DrinkRepository;
import org.apache.coyote.Response;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository repository;

    @Override
    public List<Drink> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public ResponseEntity<Drink> add(DrinkDTO drink) {

        var newDrink = new Drink();

        newDrink.setName(drink.getName());
        newDrink.setCoffeeRequired(drink.getCoffeeRequired());
        newDrink.setTimeRequired(drink.getTimeRequired());
        newDrink.setPrice(drink.getPrice());

        return new ResponseEntity<>(repository.save(newDrink), HttpStatus.CREATED);
    }

    @Override
    @Transactional
    public ResponseEntity<Drink> modify(Drink drink) {

        var existingDrink = repository.findById(drink.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested drink cannot be found."));

        existingDrink.setName(drink.getName());
        existingDrink.setTimeRequired(drink.getTimeRequired());
        existingDrink.setCoffeeRequired(drink.getCoffeeRequired());
        existingDrink.setPrice(drink.getPrice());

        return new ResponseEntity<>(repository.save(existingDrink), HttpStatus.ACCEPTED);
    }

    @Override
    public void remove(Drink drink) {

        var existingDrink = repository.findById(drink.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested drink cannot be found."));

        repository.delete(existingDrink);
    }

    @Override
    public ResponseEntity<Double> price(Long id) {

        var existingDrink = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested drink cannot be found."));

        return new ResponseEntity<>(existingDrink.getPrice(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<byte[]> image(Long id) {

        var existingDrink = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested drink cannot be found."));

        return new ResponseEntity<>(existingDrink.getImage(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> coffeeRequired(Long id) {

        var existingDrink = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested drink cannot be found."));

        return new ResponseEntity<>(existingDrink.getCoffeeRequired(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> timeToPrepare(Long id) {

        var existingDrink = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested drink cannot be found."));

        return new ResponseEntity<>(existingDrink.getTimeRequired(), HttpStatus.OK);
    }
}
