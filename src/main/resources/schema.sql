DROP TABLE IF EXISTS fios, doctors, patients, tickets;

CREATE TABLE IF NOT EXISTS doctors (
  id UUID NOT NULL,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  patronymic VARCHAR(100) NOT NULL,
  specialization VARCHAR(255) NOT NULL,
  start_work TIME WITHOUT TIME ZONE,
  end_work TIME WITHOUT TIME ZONE,
  CONSTRAINT pk_doctor PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS patients (
  id UUID NOT NULL,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  patronymic VARCHAR(100) NOT NULL,
  birthday date NOT NULL,
  address VARCHAR(255) NOT NULL,
  location_number INTEGER NOT NULL,
  CONSTRAINT pk_patient PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tickets (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  --doctor_id BIGINT NOT NULL,
  --patient_id BIGINT NOT NULL,
  start_time TIMESTAMP WITHOUT TIME ZONE,
  end_time TIMESTAMP WITHOUT TIME ZONE,
  ticket_status VARCHAR(255) NOT NULL,
  CONSTRAINT pk_ticket PRIMARY KEY (id)
  --CONSTRAINT fk_ticket_for_doctor FOREIGN KEY (doctor_id) REFERENCES doctors (id),
  --CONSTRAINT fk_ticket_for_patient FOREIGN KEY (patient_id) REFERENCES patients (id)
);

