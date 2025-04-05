package me.itsvaske.coffeeshopvegait.resource;

import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import me.itsvaske.coffeeshopvegait.model.Barista;
import me.itsvaske.coffeeshopvegait.model.EspressoMachine;
import me.itsvaske.coffeeshopvegait.model.Order;
import me.itsvaske.coffeeshopvegait.model.request.BaristaDTO;
import me.itsvaske.coffeeshopvegait.model.request.OrderDTO;
import me.itsvaske.coffeeshopvegait.service.CoffeeShopService;
import me.itsvaske.coffeeshopvegait.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CoffeeShopResource {

    private final OrderService service;
    private final CoffeeShopService coffeeShopService;

    public static final String PATH = "shop/";

    @RequestMapping(path = PATH + "/place-order", method = RequestMethod.POST)
    public ResponseEntity<Order> placeOrder(@Nonnull @RequestBody OrderDTO order) {
        return service.placeOrder(order);
    }

    @RequestMapping(path = PATH + "/add-barista", method = RequestMethod.POST)
    public ResponseEntity<Barista> addBarista(@Nonnull @RequestBody BaristaDTO barista, @RequestParam Long coffeeShopId) {
        return coffeeShopService.addBarista(barista, coffeeShopId);
    }

    @RequestMapping(path = PATH + "assign-machine", method = RequestMethod.POST)
    public ResponseEntity<EspressoMachine> assignMachine(@Nonnull Long baristaId) {
        return coffeeShopService.assignMachine(baristaId);
    }
}
