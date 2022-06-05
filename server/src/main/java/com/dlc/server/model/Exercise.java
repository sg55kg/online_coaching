package com.dlc.server.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private boolean isComplete;
    private int totalReps;
    private int repsComplete;
    private int sets;
    private Double intensity;
    private Double actualIntensity;
    private String exerciseType;
    private String variant;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "day_id", nullable = true, referencedColumnName = "id", columnDefinition = "integer")
    private Day day;


    public Exercise(int totalReps, int sets, Double intensity, String type, String variant, Day day) {
        this.totalReps = totalReps;
        this.sets = sets;
        this.intensity = intensity;
        this.exerciseType = type;
        this.variant = variant;
        this.day = null;
    }

    public Exercise(int totalReps, int sets, Double intensity, String type, String variant) {
        this.totalReps = totalReps;
        this.sets = sets;
        this.intensity = intensity;
        this.exerciseType = type;
        this.variant = variant;
    }



    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public int getTotalReps() {
        return totalReps;
    }

    public void setTotalReps(int totalReps) {
        this.totalReps = totalReps;
    }

    public int getRepsComplete() {
        return repsComplete;
    }

    public void setRepsComplete(int repsComplete) {
        this.repsComplete = repsComplete;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public Double getIntensity() {
        return intensity;
    }

    public void setIntensity(Double intensity) {
        this.intensity = intensity;
    }

    public Double getActualIntensity() {
        return actualIntensity;
    }

    public void setActualIntensity(Double actualIntensity) {
        this.actualIntensity = actualIntensity;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", isComplete=" + isComplete +
                ", totalReps=" + totalReps +
                ", repsComplete=" + repsComplete +
                ", sets=" + sets +
                ", intensity=" + intensity +
                ", actualIntensity=" + actualIntensity +
                ", exerciseType='" + exerciseType + '\'' +
                ", variant='" + variant + '\'' +
 //               ", day=" + day +
                '}';
    }
}
