package com.dlc.server.model;

import com.dlc.server.controller.MicroCycleController;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "micro_cycle")
public class MicroCycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    private Date startDate;
    @OneToMany(
            mappedBy = "microCycle",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private Set<Week> weeks;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "macro_cycle_id", nullable = true)
    private MacroCycle macroCycle;
    private int totalReps;
    private boolean isComplete;


    public MicroCycle(Date startDate, MacroCycle macroCycle) {
        this.startDate = startDate;
        this.macroCycle = macroCycle;
        this.totalReps = 0;
        this.isComplete = false;
    }

    public MicroCycle(Date startDate, MacroCycle macroCycle, int totalReps) {
        this.startDate = startDate;
        this.macroCycle = macroCycle;
        this.totalReps = totalReps;
        this.isComplete = false;
    }

    public MicroCycle(Date startDate, MacroCycle macroCycle, int totalReps, boolean isComplete) {
        this.startDate = startDate;
        this.macroCycle = macroCycle;
        this.totalReps = totalReps;
        this.isComplete = isComplete;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Set<Week> getWeeks() {
        return weeks;
    }

    public void setWeeks(Set<Week> weeks) {
        this.weeks = weeks;
    }

    public int getTotalReps() {
        return totalReps;
    }

    public void setTotalReps(int totalReps) {
        this.totalReps = totalReps;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public MacroCycle getMacroCycle() {
        return macroCycle;
    }

    public void setMacroCycle(MacroCycle macroCycle) {
        this.macroCycle = macroCycle;
    }

    @Override
    public String toString() {
        return "MicroCycle{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", startDate=" + startDate +
                ", weeks=" + weeks +
                ", macroCycle=" + macroCycle +
                ", totalReps=" + totalReps +
                ", isComplete=" + isComplete +
                '}';
    }
}
