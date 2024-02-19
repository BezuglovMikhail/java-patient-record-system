package ru.bezuglov.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.bezuglov.dto.DoctorNewDto;
import ru.bezuglov.dto.DoctorShortDto;
import ru.bezuglov.dto.FIODto;
import ru.bezuglov.service.DoctorService;
import ru.bezuglov.until.Specialization;

import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = DoctorController.class)
class DoctorControllerTest {

    @Autowired
    ObjectMapper mapper;

    @MockBean
    DoctorService doctorService;

    @Autowired
    private MockMvc mvc;

    FIODto fioDto = new FIODto();


    DoctorNewDto doctorNewDto = new DoctorNewDto();


    DoctorShortDto doctorShortDto = new DoctorShortDto();


    @BeforeEach
    void setUp() {

        //FIODto fioDto = new FIODto();


        doctorShortDto.setFio(fioDto);
        doctorShortDto.setSpecialization(Specialization.OCULIST);
        doctorShortDto.setId(1L);
    }

    @Test
    void saveDoctor() throws Exception {
        when(doctorService.save(any()))
                .thenReturn(doctorShortDto);

        fioDto.setFirstName("firstName");
        fioDto.setLastName("lastName");
        fioDto.setPatronymic("patronymic");

        doctorNewDto.setFio(fioDto);
        doctorNewDto.setSpecialization(Specialization.OCULIST);
        doctorNewDto.setStartWork(LocalTime.of(10, 00));
        doctorNewDto.setEndWork(LocalTime.of(17, 00));

        mvc.perform(post("/doctors")
                        .content(mapper.writeValueAsString(doctorShortDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                //.header(USER_ID, userIdTest))

                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(doctorShortDto.getId()), Long.class))
                //.andExpect(jsonPath("$.fio", is(doctorShortDto.getFio()), FIODto.class))
                .andExpect(jsonPath("$.specialization", is(doctorShortDto.getSpecialization().toString()),
                        Specialization.class))
                .andExpect(jsonPath("$.fio", is(doctorShortDto.getFio()), FIODto.class));

        //Mockito.verify(doctorService, Mockito.times(1))
         //       .save(doctorNewDto);

       // Mockito.verifyNoMoreInteractions(doctorService);
    }

    @Test
    void getListDoctors() {
    }

    @Test
    void getDoctor() {
    }

    @Test
    void updateDoctor() {
    }

    @Test
    void deleteDoctor() {
    }
}