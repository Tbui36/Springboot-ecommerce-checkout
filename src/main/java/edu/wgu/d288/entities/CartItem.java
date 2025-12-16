package edu.wgu.d288.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
public class CartItem {

    public CartItem() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    @ManyToMany
    @JoinTable(
            name = "excursion_cartitem",
            joinColumns = @JoinColumn(name = "cart_item_id"),
            inverseJoinColumns = @JoinColumn(name = "excursion_id")
    )
    private Set<Excursion> excursions;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date create_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;
}
