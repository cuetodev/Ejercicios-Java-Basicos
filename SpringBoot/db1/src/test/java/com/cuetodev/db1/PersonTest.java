package com.cuetodev.db1;

import com.cuetodev.db1.Persona.application.port.PersonaPort;
import com.cuetodev.db1.Persona.domain.Persona;
import com.cuetodev.db1.Persona.infrastructure.controller.PersonaController;
import com.cuetodev.db1.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PersonaController.class)
public class PersonTest {

    Persona personTest = new Persona(1, "userTest", "testPassword", "testName", "testSurname", "testCompany@gmail.com", "testPersonal@gmail.com", "testCity", true, new Date(), "testImageURL", new Date());

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PersonaPort personRepo;

    @Test
    public void getPersonByID() throws Exception {
        when(personRepo.findPersonaById(1)).thenReturn(personTest);
        mockMvc.perform(get("/persona/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getPeopleByUsuario() throws Exception {
        System.out.println("*** Buscar personas dado un usuario ***");
        List<Persona> people = new ArrayList<>();
        people.add(personTest);

        when(personRepo.findPersonaByUsuario("name")).thenReturn(people);
        mockMvc.perform(get("/persona/usuario/{usuario}", "userTest")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllPersons() throws Exception {
        System.out.println("*** Buscar todas las personas ***");
        List<Persona> persons = new ArrayList<>();
        persons.add(this.personTest);

        when(personRepo.getAllPeople()).thenReturn(persons);
        mockMvc.perform(get("/persona/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deletePersonByID() throws Exception {
        System.out.println("*** Borrando una persona ***");
        when(personRepo.deletePerson(1)).thenReturn(1);
        mockMvc.perform(delete("/persona/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    public void insertPersona() throws Exception {
        System.out.println("*** Añadiendo una persona ***");
        PersonaInputDTO personaInputDTO = new PersonaInputDTO(1, "userTest", "testPassword", "testName", "testSurname", "testCompany@gmail.com", "testPersonal@gmail.com", "testCity", true, new Date(), "testImageURL", new Date());
        mockMvc.perform(post("/persona").content(objectMapper.writeValueAsString(personaInputDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
