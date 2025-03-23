package me.itsvaske.coffeeshopvegait.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Barman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private CoffeeShop coffeeShop;
}
