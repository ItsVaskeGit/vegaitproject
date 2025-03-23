package me.itsvaske.coffeeshopvegait.resource;

import lombok.RequiredArgsConstructor;
import me.itsvaske.coffeeshopvegait.model.Drink;
import me.itsvaske.coffeeshopvegait.model.request.DrinkDTO;
import me.itsvaske.coffeeshopvegait.repo.DrinkRepository;
import me.itsvaske.coffeeshopvegait.repo.OrderRepository;
import me.itsvaske.coffeeshopvegait.service.DrinkService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DrinkResource {

    private final DrinkService drinkService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Drink addDrink(@RequestBody DrinkDTO drink) {
        return drinkService.add(drink);
    }

    @RequestMapping(path = "/modify", method = RequestMethod.PUT)
    public Drink modifyDrink(@RequestBody Drink drink) {
        return drinkService.modify(drink);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public void deleteDrink(@RequestBody Drink drink) {
        drinkService.remove(drink);
    }

    @RequestMapping(path = "/price", method = RequestMethod.GET)
    public double getPrice(Long id) {
        return drinkService.price(id);
    }

    @RequestMapping(path = "/picture", method = RequestMethod.GET)
    public byte[] getImage(Long id) {
        return drinkService.image(id);
    }

    @RequestMapping(path = "/time", method = RequestMethod.GET)
    public int getTime(Long id) {
        return drinkService.timeToPrepare(id);
    }

    @RequestMapping(path = "/coffee-required", method = RequestMethod.GET)
    public int getCoffeeRequired(Long id) {
        return drinkService.coffeeRequired(id);
    }
}
