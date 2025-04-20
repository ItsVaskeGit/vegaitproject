package me.itsvaske.coffeeshopvegait.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.itsvaske.coffeeshopvegait.model.Barman;
import me.itsvaske.coffeeshopvegait.model.Customer;
import me.itsvaske.coffeeshopvegait.model.Drink;
import me.itsvaske.coffeeshopvegait.model.OrderType;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {

    private OrderType orderType;
    private List<Drink> drinks;
    private Customer customer;
    private Barman barman;
    private double subtotal;
}
