package com.dlc.server.model;



import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "macro_cycle")
public class MacroCycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition="TIMESTAMP WITHOUT TIMEZONE")
    private Date createdOn;

    private Date startDate;

    @OneToMany(
            mappedBy = "macroCycle",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<MicroCycle> microCycles;

    private int totalReps;

    private boolean isComplete;

    public MacroCycle() {

    }

    public MacroCycle(Date startDate) {
        this.startDate = startDate;
        this.totalReps = 0;
        this.isComplete = false;
    }

    public MacroCycle(Date startDate, int totalReps) {
        this.startDate = startDate;
        this.totalReps = totalReps;
        this.isComplete = false;
    }

    public MacroCycle(Date startDate, int totalReps, boolean isComplete) {
        this.startDate = startDate;
        this.totalReps = totalReps;
        this.isComplete = isComplete;
    }



    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
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

    public Set<MicroCycle> getMicroCycles() {
        return microCycles;
    }

    public void setMicroCycles(Set<MicroCycle> microCycles) {
        this.microCycles = microCycles;
    }

    public int getTotalReps() {
        return totalReps;
    }

    public void setTotalReps(int totalReps) {
        this.totalReps = totalReps;
    }

    @Override
    public String toString() {
        return "MacroCycle{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", startDate=" + startDate +
                ", microCycles=" + microCycles +
                ", totalReps=" + totalReps +
                ", isComplete=" + isComplete +
                '}';
    }
}
