package com.railwatch.pnr.service;

import com.railwatch.common.exception.PnrNotFoundException;
import com.railwatch.pnr.domain.Pnr;
import com.railwatch.pnr.repository.PnrRepository;
import org.springframework.stereotype.Service;
import com.railwatch.pnr.dto.PnrResponse;

@Service
public class PnrService {

    private final PnrRepository pnrRepository;

    public PnrService(PnrRepository pnrRepository) {
        this.pnrRepository = pnrRepository;
    }

    public PnrResponse getPnr(String pnr) {

        Pnr pnrData = pnrRepository.findByPnr(pnr)
                .orElseThrow(() -> new PnrNotFoundException("PNR not found"));

        return new PnrResponse(
                pnrData.getPnr(),
                pnrData.getStatus().name()
        );
    }
}

