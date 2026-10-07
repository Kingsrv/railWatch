package com.railwatch.pnr.service;

import com.railwatch.common.exception.PnrNotFoundException;
import com.railwatch.pnr.domain.Pnr;
import com.railwatch.pnr.provider.PnrProvider;
import com.railwatch.pnr.repository.PnrRepository;
import org.springframework.stereotype.Service;
import com.railwatch.pnr.dto.PnrResponse;

@Service
public class PnrService {

    private final PnrProvider pnrProvider;

    public PnrService(PnrProvider pnrProvider) {
        this.pnrProvider = pnrProvider;
    }
    public PnrResponse getPnr(String pnr) {

        Pnr pnrData = pnrProvider.getPnrStatus(pnr);

        return new PnrResponse(
                pnrData.getPnr(),
                pnrData.getStatus().name(),
                pnrData.getPassengers()
        );
    }
}

