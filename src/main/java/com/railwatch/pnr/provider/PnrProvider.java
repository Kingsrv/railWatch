package com.railwatch.pnr.provider;

import com.railwatch.pnr.domain.Pnr;

public interface PnrProvider {
    Pnr getPnrStatus(String pnr);
}
