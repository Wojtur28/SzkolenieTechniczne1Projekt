package com.example.szkolenietechniczne1projekt.models;

import javax.persistence.*;

@Entity
@Table(name = "machines")
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "condition")
    private String condition;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "hall_id")
    private Long hallId;

    public Machine() {
    }

    public Machine(Long id, String name, String condition, int quantity, Long hallId) {
        this.id = id;
        this.name = name;
        this.condition = condition;
        this.quantity = quantity;
        this.hallId = hallId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
}
