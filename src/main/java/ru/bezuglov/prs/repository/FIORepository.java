package ru.bezuglov.prs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bezuglov.prs.model.FIO;

public interface FIORepository extends JpaRepository<FIO, Long> {
}
