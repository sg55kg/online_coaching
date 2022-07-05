package com.dlc.server.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "team")
public class Team { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id", referencedColumnName = "id", columnDefinition = "integer")
    private Coach coach;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    private Set<Athlete> athletes;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    private Set<MacroCycle> allPrograms;

    public Team() {}

    public Team(String name, Coach coach, Set<Athlete> athletes, Date createdOn, Set<MacroCycle> allPrograms) {
        this.name = name;
        this.coach = coach;
        this.athletes = athletes;
        this.createdOn = createdOn;
        this.allPrograms = allPrograms;
    }

    public Team(String name) {
        this.name = name;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Set<Athlete> getAthletes() {
        return athletes;
    }

    public void setAthletes(Set<Athlete> athletes) {
        this.athletes = athletes;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Set<MacroCycle> getAllPrograms() {
        return allPrograms;
    }

    public void setAllPrograms(Set<MacroCycle> allPrograms) {
        this.allPrograms = allPrograms;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coach=" + coach +
                ", athletes=" + athletes +
                ", createdOn=" + createdOn +
                ", allPrograms=" + allPrograms +
                '}';
    }
}
