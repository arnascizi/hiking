package io.github.arnascizi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "BACKPACK")
@ToString
public class Backpack {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BAG_SEQUENCE")
    @SequenceGenerator(name = "BAG_SEQUENCE", sequenceName = "BAG_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "BAG_SIZE")
    private String size;

    @Column(name = "CURRENT_WEIGHT")
    private Double currentWeight;

    @ManyToMany
    @JoinTable(
            name = "ITEM_LIST",
            joinColumns = @JoinColumn(name = "BACKPACK_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    private List<Item> itemList;
}
