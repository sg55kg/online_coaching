package com.dlc.server.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="week")
public class Week {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    private Date startDate;

    private byte weekLength;

    @OneToMany(
            mappedBy = "week",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private Set<Day> days;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "micro_cycle_id", nullable = true)
    private MicroCycle microCycle;

    private boolean isComplete;

    private int totalReps;


    public Week(Date startDate, byte weekLength, MicroCycle microCycle) {
        this.startDate = startDate;
        this.weekLength = weekLength;
        this.microCycle = microCycle;
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

    public Date getWeekStart() {
        return startDate;
    }

    public void setWeekStart(Date weekStart) {
        this.startDate = weekStart;
    }

    public byte getWeekLength() {
        return weekLength;
    }

    public void setWeekLength(byte weekLength) {
        this.weekLength = weekLength;
    }

    public Set<Day> getDays() {
        return days;
    }

    public void setDays(Set<Day> days) {
        this.days = days;
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

    public MicroCycle getMicroCycle() {
        return microCycle;
    }

    public void setMicroCycle(MicroCycle microCycle) {
        this.microCycle = microCycle;
    }

    @Override
    public String toString() {
        return "Week{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", startDate=" + startDate +
                ", weekLength=" + weekLength +
                ", days=" + days +
                ", microCycle=" + microCycle +
                ", isComplete=" + isComplete +
                ", totalReps=" + totalReps +
                '}';
    }
}
