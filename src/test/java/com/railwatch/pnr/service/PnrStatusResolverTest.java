package com.railwatch.pnr.service;

import com.railwatch.common.exception.InvalidPnrDataException;
import com.railwatch.pnr.domain.PnrStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PnrStatusResolverTest {

    private final PnrStatusResolver resolver = new PnrStatusResolver();

    @Test
    void shouldReturnConfirmedWhenAllPassengersAreConfirmed() {
        assertEquals(
                PnrStatus.CONFIRMED,
                resolver.resolve(List.of("CNF", "CNF"))
        );
    }

    @Test
    void shouldReturnRacWhenAnyPassengerIsRac() {
        assertEquals(
                PnrStatus.RAC,
                resolver.resolve(List.of("CNF", "RAC"))
        );
    }

    @Test
    void shouldReturnWaitingWhenAnyPassengerIsWaiting() {
        assertEquals(
                PnrStatus.WAITING,
                resolver.resolve(List.of("CNF", "WL"))
        );
    }

    @Test
    void shouldReturnCancelledWhenAllPassengersAreCancelled() {
        assertEquals(
                PnrStatus.CANCELLED,
                resolver.resolve(List.of("CAN", "CAN"))
        );
    }

    @Test
    void shouldPrioritizeWaitingOverRac() {
        assertEquals(
                PnrStatus.WAITING,
                resolver.resolve(List.of("RAC", "WL"))
        );
    }

    @Test
    void shouldRejectEmptyPassengerList() {
        assertThrows(
                InvalidPnrDataException.class,
                () -> resolver.resolve(List.of())
        );
    }

    @Test
    void shouldRejectUnknownPassengerStatus() {
        assertThrows(
                InvalidPnrDataException.class,
                () -> resolver.resolve(List.of("UNKNOWN"))
        );
    }
}