package me.itsvaske.coffeeshopvegait.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DrinkType drinkType;

    @ManyToOne
    private Order order;
}
