package com.joaodurante.springproject.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    @ManyToOne
    @JoinColumn(name="state_id")
    private State state;

    public City(){}
    public City(Integer id, String name, State state){
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public String getName() { return name; }
    public State getState() { return state; }

    public void setName(String name) { this.name = name; }
    public void setState(State state) { this.state = state; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id.equals(city.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
