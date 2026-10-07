CREATE TABLE pnr_passenger_entity (
  id BIGSERIAL PRIMARY KEY,
  passenger_number INTEGER NOT NULL,
  booking_status VARCHAR(255),
  booking_berth_number INTEGER,
  current_status VARCHAR(255),
  current_berth_number INTEGER,
  pnr VARCHAR(255) NOT NULL,

  CONSTRAINT fk_pnr_passenger_pnr
      FOREIGN KEY (pnr)
          REFERENCES pnr_entity (pnr)
          ON DELETE CASCADE
);