package com.railwatch.pnr.repository;

import com.railwatch.pnr.domain.Pnr;
import com.railwatch.pnr.domain.PnrStatus;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryPnrRepository implements PnrRepository {

    private final Map<String, Pnr> pnrs = new HashMap<>();

    public InMemoryPnrRepository() {
        pnrs.put("1234567890", new Pnr("1234567890", PnrStatus.WAITING));
    }

    @Override
    public Optional<Pnr> findByPnr(String pnr) {
        return Optional.ofNullable(pnrs.get(pnr));
    }
}