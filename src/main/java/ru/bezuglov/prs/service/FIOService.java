package ru.bezuglov.prs.service;

import ru.bezuglov.prs.dto.FIODto;

public interface FIOService {

    void save(FIODto fioDto);

    void update(FIODto fioDto);

    void delete(Long id);

    FIODto findFIO(Long id);
}
