package edu.wgu.d288.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "divisions")
@Getter
@Setter
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")   // ✅ CRITICAL FIX
    private Long id;

    @Column(name = "division")
    private String division_name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date create_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
