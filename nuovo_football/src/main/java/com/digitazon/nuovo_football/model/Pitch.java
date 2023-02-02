package com.digitazon.nuovo_football.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data //Lombok
@NoArgsConstructor //Per creare costruttore vuoto da solo e getter/setter e toString()
public class Pitch {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column 
    private String dimension;

    @Column
    private int price;

    @OneToMany
    private List<Booking> bookings;

    public Pitch(String name, String dimension, int price, List<Booking> bookings) {
        this.name = name;
        this.dimension = dimension;
        this.price = price;
        this.bookings = bookings;
    }

    

    

    
}
