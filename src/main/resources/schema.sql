DROP TABLE IF EXISTS fios, doctors, patients, tickets;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS doctors (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  personal_number UUID DEFAULT UUID_GENERATE_V4 (),
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  patronymic VARCHAR(100) NOT NULL,
  specialization VARCHAR(255) NOT NULL,
  start_work TIME WITHOUT TIME ZONE,
  end_work TIME WITHOUT TIME ZONE,
  CONSTRAINT pk_doctor PRIMARY KEY (id),
  CONSTRAINT uq_doctors_for_first_name_last_name_patronymic_specialization
  UNIQUE (first_name, last_name, patronymic, specialization)
);

CREATE TABLE IF NOT EXISTS patients (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  card_number UUID DEFAULT UUID_GENERATE_V4 (),
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  patronymic VARCHAR(100) NOT NULL,
  birthday date NOT NULL,
  address VARCHAR(255) NOT NULL,
  location_number INTEGER NOT NULL,
  CONSTRAINT pk_patient PRIMARY KEY (id),
  CONSTRAINT uq_patients_for_first_name_last_name_patronymic_birthday
  UNIQUE (first_name, last_name, patronymic, birthday)
);

CREATE TABLE IF NOT EXISTS tickets (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  doctor_id BIGINT,
  patient_id BIGINT,
  start_time TIMESTAMP WITHOUT TIME ZONE,
  end_time TIMESTAMP WITHOUT TIME ZONE,
  status VARCHAR(255),
  CONSTRAINT pk_ticket PRIMARY KEY (id),
  CONSTRAINT fk_ticket_for_doctor FOREIGN KEY (doctor_id) REFERENCES doctors (id),
  CONSTRAINT fk_ticket_for_patient FOREIGN KEY (patient_id) REFERENCES patients (id)
  --CONSTRAINT uq_tickets_for_doctor_id_patient_id_start_time UNIQUE (doctor_id, patient_id, start_time)
);
