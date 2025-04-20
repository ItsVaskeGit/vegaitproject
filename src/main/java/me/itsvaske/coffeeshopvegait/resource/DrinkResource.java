package me.itsvaske.coffeeshopvegait.resource;

import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import me.itsvaske.coffeeshopvegait.model.Drink;
import me.itsvaske.coffeeshopvegait.model.request.DrinkDTO;
import me.itsvaske.coffeeshopvegait.service.DrinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DrinkResource {

    private final DrinkService drinkService;

    public static final String PATH = "drink";

    @RequestMapping(path = PATH + "/add", method = RequestMethod.POST)
    public ResponseEntity<Drink> addDrink(@Nonnull @RequestBody DrinkDTO drink) {
        return drinkService.add(drink);
    }

    @RequestMapping(path = PATH + "/modify", method = RequestMethod.PUT)
    public ResponseEntity<Drink> modifyDrink(@Nonnull @RequestBody Drink drink) {
        return drinkService.modify(drink);
    }

    @RequestMapping(path = PATH + "/delete", method = RequestMethod.DELETE)
    public void deleteDrink(@Nonnull @RequestBody Drink drink) {
        drinkService.remove(drink);
    }

    @RequestMapping(path = PATH + "/price", method = RequestMethod.GET)
    public ResponseEntity<Double> getPrice(Long id) {
        return drinkService.price(id);
    }

    @RequestMapping(path = PATH + "/picture", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(Long id) {
        return drinkService.image(id);
    }

    @RequestMapping(path = PATH + "/time", method = RequestMethod.GET)
    public ResponseEntity<Integer> getTime(Long id) {
        return drinkService.timeToPrepare(id);
    }

    @RequestMapping(path = PATH + "/coffee-required", method = RequestMethod.GET)
    public ResponseEntity<Integer> getCoffeeRequired(Long id) {
        return drinkService.coffeeRequired(id);
    }
}
