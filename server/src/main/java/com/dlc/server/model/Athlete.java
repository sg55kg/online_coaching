package com.dlc.server.model;


import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "athlete")
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String name;
    private String email;
    private String passwordHash;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coach_id", referencedColumnName = "id", columnDefinition = "integer")
    private Coach coach;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "athlete", cascade = CascadeType.ALL)
    private Set<MacroCycle> programs;
    @ManyToOne
    private Team team;
    private Date joinedOn;
    private Date lastLogin;

    public Athlete() {}

    public Athlete(String name, String email, String passwordHash, Coach coach, Set<MacroCycle> programs, Team team, Date joinedOn, Date lastLogin) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.coach = coach;
        this.programs = programs;
        this.team = team;
        this.joinedOn = joinedOn;
        this.lastLogin = lastLogin;
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

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Set<MacroCycle> getPrograms() {
        return programs;
    }

    public void setPrograms(Set<MacroCycle> programs) {
        this.programs = programs;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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

    @Override
    public String toString() {
        return "Athlete{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", coach=" + coach +
                ", programs=" + programs +
                ", team=" + team +
                ", joinedOn=" + joinedOn +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
