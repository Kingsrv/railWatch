package com.railwatch.pnr.dto;

public class PnrResponse {
    private String pnr;
    private String status;

    public PnrResponse(String pnr, String status) {
        this.pnr = pnr;
        this.status = status;
    }

    public String getPnr() {
        return pnr;
    }

    public String getStatus() {
        return status;
    }
}
