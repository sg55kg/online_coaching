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
    @ManyToOne
    private Coach owner;
    @OneToMany
    private Set<Athlete> athletes;
    private Date createdOn;
    @OneToMany
    private Set<MacroCycle> allPrograms;

    public Team() {}

    public Team(String name, Coach owner, Set<Athlete> athletes, Date createdOn, Set<MacroCycle> allPrograms) {
        this.name = name;
        this.owner = owner;
        this.athletes = athletes;
        this.createdOn = createdOn;
        this.allPrograms = allPrograms;
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

    public Coach getOwner() {
        return owner;
    }

    public void setOwner(Coach owner) {
        this.owner = owner;
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
                ", owner=" + owner +
                ", athletes=" + athletes +
                ", createdOn=" + createdOn +
                ", allPrograms=" + allPrograms +
                '}';
    }
}
