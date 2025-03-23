package me.itsvaske.coffeeshopvegait.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.itsvaske.coffeeshopvegait.model.Drink;
import me.itsvaske.coffeeshopvegait.model.request.DrinkDTO;
import me.itsvaske.coffeeshopvegait.repo.DrinkRepository;

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

        return repository.save(newDrink);
    }

    @Override
    @Transactional
    public Drink modify(Drink drink) {

        var existingDrink = repository.findById(drink.getId()).orElseThrow();

        existingDrink.setName(drink.getName());
        existingDrink.setTimeRequired(drink.getTimeRequired());
        existingDrink.setCoffeeRequired(drink.getCoffeeRequired());

        return repository.save(existingDrink);
    }

    @Override
    public void remove(Drink drink) {

        var existingDrink = repository.findById(drink.getId()).orElseThrow();

        repository.delete(existingDrink);
    }

    @Override
    public double price(Long id) {

        var existingDrink = repository.findById(id).orElseThrow();

        return existingDrink.getPrice();
    }

    @Override
    public byte[] image(Long id) {

        var existingDrink = repository.findById(id).orElseThrow();

        return existingDrink.getImage();
    }

    @Override
    public int coffeeRequired(Long id) {

        var existingDrink = repository.findById(id).orElseThrow();

        return existingDrink.getCoffeeRequired();
    }

    @Override
    public int timeToPrepare(Long id) {

        var existingDrink = repository.findById(id).orElseThrow();

        return existingDrink.getTimeRequired();
    }
}
