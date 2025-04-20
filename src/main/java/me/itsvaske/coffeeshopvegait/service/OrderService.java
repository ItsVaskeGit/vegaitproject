package me.itsvaske.coffeeshopvegait.service;

import me.itsvaske.coffeeshopvegait.model.Order;
import me.itsvaske.coffeeshopvegait.model.request.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    ResponseEntity<Order> placeOrder(OrderDTO order);

}
