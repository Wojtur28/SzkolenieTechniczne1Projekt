
package com.example.szkolenietechniczne1projekt.models;

import javax.persistence.*;

@Entity
@Table(name = "halls")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column (name = "size")
    private int size;
    @Column(name = "is_cleaned", columnDefinition = "BOOLEAN")
    private boolean isCleaned;

    public Hall() {
    }

    public Hall(Long id, String name, int size, boolean isCleaned) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.isCleaned = isCleaned;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean getIsCleaned() {
        return isCleaned;
    }

    public void setCleaned(boolean cleaned) {
        isCleaned = cleaned;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", isCleaned=" + isCleaned +
                '}';
    }
}

