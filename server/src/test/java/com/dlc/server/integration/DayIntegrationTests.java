package com.dlc.server.integration;

import com.dlc.server.controller.CoachController;
import com.dlc.server.model.Day;
import com.dlc.server.repository.CoachRepository;
import com.dlc.server.repository.DayRepository;
import com.dlc.server.service.CoachServiceImpl;
import com.dlc.server.service.DayServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigInteger;
import java.util.Optional;

import static com.dlc.server.util.TestHelpers.asJsonString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DayIntegrationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private DayServiceImpl dayService;
    @MockBean
    private DayRepository dayRepository;
    @MockBean
    private CoachController coachController;
    @MockBean
    private CoachServiceImpl coachService;
    @MockBean
    private CoachRepository coachRepository;

    @Test
    @WithMockUser(roles = { "coach" })
    public void addDayTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/data/day/add")
                .content(asJsonString(new Day()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser(roles = { "coach" })
    public void updateDayTest() throws Exception {
        Day day = new Day();
        BigInteger id = BigInteger.TEN;
        day.setId(id);

        given(dayRepository.findById(id)).willReturn(Optional.of(new Day()));

        mockMvc.perform(MockMvcRequestBuilders
                .put("/data/day/update")
                .content(asJsonString(new Day()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
