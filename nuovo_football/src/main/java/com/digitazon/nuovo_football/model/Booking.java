package com.digitazon.nuovo_football.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String day;

    @Column
    private String hour;

    @ManyToOne
    private Pitch pitch;

    @ManyToOne
    private User user;

    public Booking(String day, String hour, Pitch pitch, User user) {
        this.day = day;
        this.hour = hour;
        this.pitch = pitch;
        this.user = user;
    }

    
    


}
