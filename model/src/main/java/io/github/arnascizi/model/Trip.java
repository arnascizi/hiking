package io.github.arnascizi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "TRIP")
@ToString
public class Trip {
    // TODO add trip length in days, distance divided by average persons pace
    // add person entity to determine average caloric intake for a day during trips

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRIP_SEQUENCE")
    @SequenceGenerator(name = "TRIP_SEQUENCE", sequenceName = "TRIP_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "DISTANCE")
    private Integer distance;

    @Column(name = "SEASON")
    private String season;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "BACKPACK_ID")
    private Backpack backpack;
}
