package com.dlc.server.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "coach")
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String name;
    private String email;
    private String passwordHash;
    @OneToMany(mappedBy = "coach", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Team> teams;
    @OneToMany(mappedBy = "coach", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Athlete> athletes;
    @OneToMany(mappedBy = "coach", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<MacroCycle> programs;
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinedOn;
    private Date lastLogin;
    private boolean isPaid;

    public Coach() {

    }

    public Coach(String name, String email, String passwordHash, Set<Team> teams, Set<Athlete> athletes, Set<MacroCycle> programs, Date joinedOn, Date lastLogin) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.teams = teams;
        this.athletes = athletes;
        this.programs = programs;
        this.joinedOn = joinedOn;
        this.lastLogin = lastLogin;
    }

    public Coach(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Set<Athlete> getAthletes() {
        return athletes;
    }

    public void setAthletes(Set<Athlete> athletes) {
        this.athletes = athletes;
    }

    public Set<MacroCycle> getPrograms() {
        return programs;
    }

    public void setPrograms(Set<MacroCycle> programs) {
        this.programs = programs;
    }

    public Date getJoinedOn() {
        return joinedOn;
    }

    public void setJoinedOn(Date joinedOn) {
        this.joinedOn = joinedOn;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", teams=" + teams +
                ", athletes=" + athletes +
                ", programs=" + programs +
                ", joinedOn=" + joinedOn +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
