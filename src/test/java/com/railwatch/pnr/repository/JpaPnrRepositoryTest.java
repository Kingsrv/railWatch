package com.railwatch.pnr.repository;

import com.railwatch.pnr.domain.Pnr;
import com.railwatch.pnr.domain.PnrStatus;
import com.railwatch.pnr.entity.PnrEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import(JpaPnrRepository.class)
public class JpaPnrRepositoryTest {

    @Autowired
    private PnrJpaRepository pnrJpaRepository;

    @Autowired
    private JpaPnrRepository jpaPnrRepository;

    @Test
    void shouldFindPnrById() {

        PnrEntity entity =
                new PnrEntity("1234567890", PnrStatus.WAITING);

        pnrJpaRepository.save(entity);

        PnrEntity result =
                pnrJpaRepository.findById("1234567890")
                        .orElseThrow();

        assertEquals("1234567890", result.getPnr());
        assertEquals(PnrStatus.WAITING, result.getStatus());
    }


    @Test
    void shouldConvertEntityToDomainObject() {

        PnrEntity entity =
                new PnrEntity("1234567890", PnrStatus.WAITING);

        pnrJpaRepository.save(entity);

        Pnr result =
                jpaPnrRepository.findByPnr("1234567890")
                        .orElseThrow();

        assertEquals("1234567890", result.getPnr());
        assertEquals(PnrStatus.WAITING, result.getStatus());
    }
}
