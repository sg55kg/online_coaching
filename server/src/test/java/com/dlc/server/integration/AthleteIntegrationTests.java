package com.dlc.server.integration;

import com.dlc.server.controller.CoachController;
import com.dlc.server.model.Athlete;
import com.dlc.server.repository.AthleteRepository;
import com.dlc.server.repository.CoachRepository;
import com.dlc.server.service.AthleteServiceImpl;
import com.dlc.server.service.CoachServiceImpl;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigInteger;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AthleteIntegrationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AthleteServiceImpl athleteService;
    @MockBean
    private AthleteRepository athleteRepository;
    @MockBean
    private CoachController coachController;
    @MockBean
    private CoachServiceImpl coachService;
    @MockBean
    private CoachRepository coachRepository;

    @Test
    @WithMockUser(roles = { "athlete" })
    public void getAthleteByIdTest() throws Exception {
        Athlete athlete = new Athlete(
                "Test Name",
                "test@gmail.com",
                "hash",
                null,
                null,
                null,
                null,
                null);
        BigInteger id = BigInteger.valueOf(57);
        athlete.setId(id);
        given(athleteRepository.findById(id)).willReturn(Optional.of(athlete));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/data/athlete/{id}", String.valueOf(id)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test Name"))
                .andExpect(jsonPath("$.email").value("test@gmail.com"));
    }

    @Test
    @WithMockUser(roles = { "athlete" })
    public void getAthleteByIdIsNullTest() throws Exception {
        BigInteger id = BigInteger.valueOf(10);
        given(athleteRepository.findById(id)).willReturn(Optional.empty());

        mockMvc.perform(MockMvcRequestBuilders
                .get("/data/athlete/{id}", String.valueOf(id)))
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(roles = { "" })
    public void getAthleteByIdUnauthorizedTest() throws Exception {
        BigInteger id = BigInteger.TEN;

        mockMvc.perform(MockMvcRequestBuilders
                .get("/data/athlete/{id}", id))
                .andExpect(status().isForbidden());
    }
}
