package com.dlc.server.integration;

import com.dlc.server.controller.CoachController;
import com.dlc.server.model.MicroCycle;
import com.dlc.server.model.Week;
import com.dlc.server.repository.CoachRepository;
import com.dlc.server.repository.WeekRepository;
import com.dlc.server.service.CoachServiceImpl;
import com.dlc.server.service.WeekServiceImpl;
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
import java.util.Date;

import static com.dlc.server.util.TestHelpers.asJsonString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WeekIntegrationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WeekServiceImpl weekService;
    @MockBean
    private WeekRepository weekRepository;
    @MockBean
    private CoachController coachController;
    @MockBean
    private CoachServiceImpl coachService;
    @MockBean
    private CoachRepository coachRepository;

    @Test
    @WithMockUser(roles = { "athlete" })
    public void addWeekTest() throws Exception {
//        Date newDate = new Date();
//        MicroCycle parent = new MicroCycle();
//        Week week = new Week(newDate, (byte) 5, parent);
//        Week savedWeek = new Week(newDate, (byte) 5, parent);
//        savedWeek.setId(BigInteger.TEN);
//
//        given(weekRepository.save(week)).willReturn(savedWeek);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/data/week/add")
                .content(asJsonString(new Week(new Date(), (byte) 5, new MicroCycle())))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.weekLength").value((byte)5))
                .andReturn().getResponse().getContentAsString();
    }
}
