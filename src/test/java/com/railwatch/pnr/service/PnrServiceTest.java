package com.railwatch.pnr.service;

import com.railwatch.common.exception.PnrNotFoundException;
import com.railwatch.pnr.domain.Pnr;
import com.railwatch.pnr.domain.PnrStatus;
import com.railwatch.pnr.dto.PnrResponse;
import com.railwatch.pnr.repository.PnrRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PnrServiceTest {

    private final PnrRepository pnrRepository = mock(PnrRepository.class);

    private final PnrService pnrService =
            new PnrService(pnrRepository);

    @Test
    void shouldReturnPnrResponse() {

        Pnr pnr = new Pnr("1234567890", PnrStatus.WAITING);

        when(pnrRepository.findByPnr("1234567890"))
                .thenReturn(Optional.of(pnr));

        PnrResponse response =
                pnrService.getPnr("1234567890");

        assertEquals("1234567890", response.getPnr());
        assertEquals("WAITING", response.getStatus());
    }


    @Test
    void shouldThrowExceptionWhenPnrDoesNotExist() {

        when(pnrRepository.findByPnr("9999999999"))
                .thenReturn(Optional.empty());

        PnrNotFoundException exception =
                org.junit.jupiter.api.Assertions.assertThrows(
                        PnrNotFoundException.class,
                        () -> pnrService.getPnr("9999999999")
                );

        assertEquals("PNR not found", exception.getMessage());
    }
}