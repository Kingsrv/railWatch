package com.railwatch.pnr.repository;

import com.railwatch.pnr.entity.PnrEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PnrJpaRepository extends JpaRepository<PnrEntity, String> {
}
