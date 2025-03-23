package me.itsvaske.coffeeshopvegait.resource;

import me.itsvaske.coffeeshopvegait.model.Order;
import me.itsvaske.coffeeshopvegait.model.request.OrderDTO;
import me.itsvaske.coffeeshopvegait.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeShopResource {

    @Autowired
    private OrderService service;

    @RequestMapping(path = "/place-order", method = RequestMethod.POST)
    public ResponseEntity<Order> placeOrder(@RequestBody OrderDTO order) {
        return service.placeOrder(order);
    }
}
