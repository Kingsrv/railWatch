package com.railwatch.pnr.service;

import com.railwatch.common.exception.PnrNotFoundException;
import com.railwatch.pnr.domain.Pnr;
import com.railwatch.pnr.domain.PnrStatus;
import com.railwatch.pnr.provider.PnrProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PnrServiceTest {

    @Mock
    private PnrProvider pnrProvider;

    @InjectMocks
    private PnrService pnrService;

    @Test
    void shouldReturnPnrResponse() {

        when(pnrProvider.getPnrStatus("1234567890"))
                .thenReturn(
                        new Pnr("1234567890", PnrStatus.WAITING, java.util.List.of())
                );

        var result = pnrService.getPnr("1234567890");

        assertEquals("1234567890", result.getPnr());
        assertEquals("WAITING", result.getStatus());
    }

    @Test
    void shouldThrowExceptionWhenPnrDoesNotExist() {

        when(pnrProvider.getPnrStatus("9999999999"))
                .thenThrow(
                        new PnrNotFoundException("PNR not found")
                );

        assertThrows(
                PnrNotFoundException.class,
                () -> pnrService.getPnr("9999999999")
        );
    }
}