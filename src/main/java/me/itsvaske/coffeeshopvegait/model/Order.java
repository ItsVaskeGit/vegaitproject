package me.itsvaske.coffeeshopvegait.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "drink_order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    @OneToMany(orphanRemoval = true)
    private List<Drink> ordered;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Barman barman;
}
