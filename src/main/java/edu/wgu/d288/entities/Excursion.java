package edu.wgu.d288.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Getter
@Setter
public class Excursion {

    public Excursion() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private Long id;

    @NotBlank
    @Size(max = 255)
    @Column(name = "excursion_title")
    private String excursion_title;

    @NotNull
    @Column(name = "excursion_price")
    private BigDecimal excursion_price;

    @NotBlank
    @Size(max = 255)
    @Column(name = "image_url")
    private String image_url;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date create_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;


    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems;
}
