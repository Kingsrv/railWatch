package com.railwatch.pnr.service;

import com.railwatch.common.exception.InvalidPnrDataException;
import com.railwatch.pnr.domain.PnrStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PnrStatusResolver {

    private static final String CONFIRMED = "CNF";
    private static final String RAC = "RAC";
    private static final String WAITING = "WL";
    private static final String CANCELLED = "CAN";

    public PnrStatus resolve(List<String> passengerStatuses) {

        if (passengerStatuses.isEmpty()) {
            throw new InvalidPnrDataException(
                    "PNR response contains no passengers"
            );
        }

        if (passengerStatuses.stream().anyMatch(
                status -> !List.of("CNF", "RAC", "WL", "CAN").contains(status))) {

            throw new InvalidPnrDataException(
                    "PNR response contains an unknown passenger status"
            );
        }

        if (passengerStatuses.stream().allMatch(CANCELLED::equals)) {
            return PnrStatus.CANCELLED;
        }

        if (passengerStatuses.stream().anyMatch(WAITING::equals)) {
            return PnrStatus.WAITING;
        }

        if (passengerStatuses.stream().anyMatch(RAC::equals)) {
            return PnrStatus.RAC;
        }

        return PnrStatus.CONFIRMED;
    }
}