package com.railwatch.pnr.entity;

import com.railwatch.pnr.domain.PnrStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class PnrEntity {

    @Id
    private String pnr;

    @Enumerated(EnumType.STRING)
    private PnrStatus status;

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
}