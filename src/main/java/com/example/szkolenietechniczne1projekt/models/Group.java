package com.example.szkolenietechniczne1projekt.models;

import javax.persistence.*;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "difficulty")
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    @Column(name = "type_training")
    private TypeTraining typeTraining;
    @Column(name = "trainer_id")
    private Long trainerId;

    public Group(Long id, String name, Difficulty difficulty, TypeTraining typeTraining, Long trainerId) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
        this.typeTraining = typeTraining;
        this.trainerId = trainerId;
    }

    public Group() {
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

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public TypeTraining getTypeTraining() {
        return typeTraining;
    }

    public void setTypeTraining(TypeTraining typeTraining) {
        this.typeTraining = typeTraining;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", difficulty=" + difficulty +
                ", typeTraining=" + typeTraining +
                ", trainerId=" + trainerId +
                '}';
    }
}

