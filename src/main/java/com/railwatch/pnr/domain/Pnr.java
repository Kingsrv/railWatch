package com.railwatch.pnr.domain;

import java.util.List;

public class Pnr {

    private final String pnr;
    private final PnrStatus status;
    private final List<PnrPassenger> passengers;

    public Pnr(
            String pnr,
            PnrStatus status,
            List<PnrPassenger> passengers) {

        this.pnr = pnr;
        this.status = status;
        this.passengers = passengers;
    }

    public String getPnr() {
        return pnr;
    }

    public PnrStatus getStatus() {
        return status;
    }

    public List<PnrPassenger> getPassengers() {
        return passengers;
    }
}