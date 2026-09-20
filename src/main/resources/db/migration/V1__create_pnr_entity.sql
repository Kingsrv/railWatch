CREATE TABLE pnr_entity (
                            pnr VARCHAR(255) NOT NULL,
                            status VARCHAR(255),
                            CONSTRAINT pnr_entity_pkey PRIMARY KEY (pnr),
                            CONSTRAINT pnr_entity_status_check
                                CHECK (status IN ('WAITING', 'CONFIRMED', 'RAC', 'CANCELLED'))
);