package me.itsvaske.coffeeshopvegait.model;

public enum DrinkType {

    ESPRESSO("espresso", 35, 7),
    ESPRESSO_DOPIO("espresso_dopio", 45, 14),
    CAPPUCINO("cappucino", 60, 7);

    private String name;
    private int timeRequired;
    private int coffeeRequired;

    DrinkType(String name, int timeRequired, int coffeeRequired) {
        this.name = name;
        this.timeRequired = timeRequired;
        this.coffeeRequired = coffeeRequired;
    }
}
