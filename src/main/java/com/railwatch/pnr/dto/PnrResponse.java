package com.railwatch.pnr.dto;

import com.railwatch.pnr.domain.PnrPassenger;

import java.util.List;

public class PnrResponse {

    private List<PnrPassenger> passengers;
    private String pnr;
    private String status;

    public PnrResponse(
            String pnr,
            String status,
            List<PnrPassenger> passengers) {

        this.pnr = pnr;
        this.status = status;
        this.passengers = passengers;
    }

    public String getPnr() {
        return pnr;
    }

    public String getStatus() {
        return status;
    }

    public List<PnrPassenger> getPassengers() {
        return passengers;
    }
}
