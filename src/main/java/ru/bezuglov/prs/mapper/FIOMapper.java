package ru.bezuglov.prs.mapper;

import lombok.experimental.UtilityClass;
import ru.bezuglov.prs.dto.FIODto;
import ru.bezuglov.prs.model.FIO;

@UtilityClass
public class FIOMapper {

    public FIODto toFIODto(FIO fio) {
        FIODto fioDto = new FIODto();
        fioDto.setFirstName(fio.getFirstName());
        fioDto.setLastName(fio.getLastName());
        fioDto.setPatronymic(fio.getPatronymic());
        return fioDto;
    }

    public FIO toFIO(FIODto fioDto) {
        FIO fio = new FIO();
        fio.setFirstName(fioDto.getFirstName());
        fio.setLastName(fioDto.getLastName());
        fio.setPatronymic(fioDto.getPatronymic());
        return fio;
    }

}
