package ru.bezuglov.mapper;

import lombok.experimental.UtilityClass;
import ru.bezuglov.dto.FIODto;
import ru.bezuglov.model.FIO;

@UtilityClass
public class FIOMapperStatic {

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
