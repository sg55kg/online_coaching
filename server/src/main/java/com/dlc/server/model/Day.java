package com.dlc.server.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "day")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private int totalReps;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    private Date date;

    private boolean isComplete;

    @OneToMany(mappedBy = "day", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Exercise> exercises;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "week_id", nullable = true, referencedColumnName = "id", columnDefinition = "integer")
    private Week week;

    public Day() {

    }

    public Day(int theTotalReps) {
        this.totalReps = theTotalReps;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public int getTotalReps() {
        return totalReps;
    }

    public void setTotalReps(int totalReps) {
        this.totalReps = totalReps;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> set) {
        this.exercises = set;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", totalReps=" + totalReps +
                ", createdOn=" + createdOn +
                ", date=" + date +
                ", isComplete=" + isComplete +
                ", exercises=" + exercises +
                ", week=" + week +
                '}';
    }
}

