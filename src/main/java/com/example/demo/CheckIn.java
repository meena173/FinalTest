package com.example.demo;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class CheckIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "checkin", cascade = CascadeType.ALL)
    private List<Guest> guests;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public List<Guest> getGuests() 
    {
        return guests;
    }

    public void setGuests(List<Guest> guests)
    {
        this.guests = guests;
    }
}
