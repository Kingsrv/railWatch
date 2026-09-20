package com.railwatch.pnr.repository;

import com.railwatch.pnr.domain.Pnr;

import java.util.Optional;

public interface PnrRepository {

    Optional<Pnr> findByPnr(String pnr);
}