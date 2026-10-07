package com.railwatch.pnr.entity;

import com.railwatch.pnr.domain.PnrStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PnrEntity {

    @Id
    private String pnr;

    @Enumerated(EnumType.STRING)
    private PnrStatus status;

    @OneToMany(
            mappedBy = "pnr",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PnrPassengerEntity> passengers = new ArrayList<>();

    public PnrEntity() {
    }

    public PnrEntity(String pnr, PnrStatus status) {
        this.pnr = pnr;
        this.status = status;
    }

    public String getPnr() {
        return pnr;
    }

    public PnrStatus getStatus() {
        return status;
    }

    public List<PnrPassengerEntity> getPassengers() {
        return passengers;
    }
}