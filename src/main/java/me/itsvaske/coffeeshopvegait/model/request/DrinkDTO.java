package me.itsvaske.coffeeshopvegait.model.request;

import lombok.Data;

@Data
public class DrinkDTO {

    private String name;

    private int timeRequired;

    private int coffeeRequired;

    private double price;

}
