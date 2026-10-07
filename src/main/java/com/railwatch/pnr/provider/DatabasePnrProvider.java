package com.railwatch.pnr.provider;

import com.railwatch.common.exception.PnrNotFoundException;
import com.railwatch.pnr.domain.Pnr;
import com.railwatch.pnr.repository.PnrRepository;
import org.springframework.stereotype.Component;

@Component
public class DatabasePnrProvider implements PnrProvider {

    private final PnrRepository pnrRepository;

    public DatabasePnrProvider(PnrRepository pnrRepository) {
        this.pnrRepository = pnrRepository;
    }

    @Override
    public Pnr getPnrStatus(String pnr) {
        return pnrRepository.findByPnr(pnr)
                .orElseThrow(() -> new PnrNotFoundException("PNR not found"));
    }
}