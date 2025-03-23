package me.itsvaske.coffeeshopvegait.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Order order;

    private String name;

    private int timeRequired;

    private int coffeeRequired;

    private double price;

    private byte[] image;
}
