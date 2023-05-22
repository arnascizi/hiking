package io.github.arnascizi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "ITEM")
@ToString
public class Item {
    // TODO create a new entity that differentiates all items from food / beverages
    // food could have caloric values to determine how much food needed for certain trip

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQUENCE")
    @SequenceGenerator(name = "ITEM_SEQUENCE", sequenceName = "ITEM_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;

    // TODO resolve item quantity to accumulate how many items needed for longer trips
    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "WEIGHT")
    private Double weight;

    @Column(name = "RECOMMENDED_SEASON")
    private String recommendedSeason;
}
