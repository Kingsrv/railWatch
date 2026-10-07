package com.railwatch.pnr.repository;

import com.railwatch.pnr.domain.Pnr;
import com.railwatch.pnr.domain.PnrPassenger;
import com.railwatch.pnr.domain.PnrStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaPnrRepository implements PnrRepository{

    private final PnrJpaRepository pnrJpaRepository;

    public JpaPnrRepository(PnrJpaRepository pnrJpaRepository) {
        this.pnrJpaRepository = pnrJpaRepository;
    }

    @Override
    public Optional<Pnr> findByPnr(String pnr) {
        return pnrJpaRepository.findById(pnr)
                .map(entity -> new Pnr(
                        entity.getPnr(),
                        entity.getStatus(),
                        entity.getPassengers()
                                .stream()
                                .map(passenger -> new PnrPassenger(
                                        passenger.getPassengerNumber(),
                                        passenger.getBookingStatus(),
                                        passenger.getBookingBerthNumber(),
                                        passenger.getCurrentStatus(),
                                        passenger.getCurrentBerthNumber()
                                ))
                                .toList()
                ));
    }
}
