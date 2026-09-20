package com.railwatch.pnr.domain;

public class Pnr {

    private final String pnr;
    private final PnrStatus status;

    public Pnr(String pnr, PnrStatus status) {
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