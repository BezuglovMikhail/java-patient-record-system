package ru.bezuglov.prs.mapper;

import lombok.experimental.UtilityClass;
import ru.bezuglov.prs.dto.FIODto;
import ru.bezuglov.prs.dto.FIONewDto;
import ru.bezuglov.prs.model.FIO;

@UtilityClass
public class FIOMapper {

    public FIODto toFIODto(FIO fio) {
        FIODto fioDto = new FIODto();
        fioDto.setId(fio.getId());
        fioDto.setFirstName(fio.getFirstName());
        fioDto.setLastName(fio.getLastName());
        fioDto.setPatronymic(fio.getPatronymic());
        return fioDto;
    }

    public FIO toFIO(FIONewDto fioNewDto) {
        FIO fio = new FIO();
        fio.setFirstName(fioNewDto.getFirstName());
        fio.setLastName(fioNewDto.getLastName());
        fio.setPatronymic(fioNewDto.getPatronymic());
        return fio;
    }

}
