package com.railwatch.pnr.provider.railkit;

import java.util.List;

public record RailKitPnrResponse(
        boolean success,
        Data data
) {

    public record Data(
            String pnr,
            List<Passenger> passengers
    ) {
    }

    public record Booking(
            String status,
            Integer berthNo
    ) {
    }

    public record Passenger(
            String serialNumber,
            Booking booking,
            Current current
    ) {
    }

    public record Current(
            String status,
            Integer berthNo
    ) {
    }
}