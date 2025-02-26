package me.itsvaske.coffeeshopvegait.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Barista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "cs_id")
    private CoffeeShop coffeeShop;

    @OneToOne
    private EspressoMachine espressoMachine;
}
