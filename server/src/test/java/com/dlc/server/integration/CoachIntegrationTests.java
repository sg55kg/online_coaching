package com.dlc.server.integration;

import com.dlc.server.model.Coach;
import com.dlc.server.repository.CoachRepository;
import com.dlc.server.service.CoachServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static com.dlc.server.util.TestHelpers.asJsonString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CoachIntegrationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CoachServiceImpl coachService;
    @MockBean
    private CoachRepository coachRepository;



    @Test
    @WithMockUser(roles = { "coach" })
    public void getCoachByEmailTest() throws Exception {
        given(coachRepository.findByEmail("fakecoach@gmail.com"))
                .willReturn(new Coach("Test", "fakecoach@gmail.com"));
        mockMvc.perform(get("/data/coach/email/{email}", "fakecoach@gmail.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("fakecoach@gmail.com"));
    }

    @Test
    @WithMockUser(roles = { "coach" })
    public void getAllCoachesTest() throws Exception {
        given(coachRepository.findAll()).willReturn(List.of(
                new Coach("test", "test@test.com"),
                new Coach("other name", "test@not.com"),
                new Coach("Third name", "gmail@yahoo.com")
        ));

        mockMvc.perform(get("/data/coach/all"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = { "" })
    public void getAllCoachesUnauthorizedTest() throws Exception {
        mockMvc.perform(get("/data/coach/all"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = { "coach" })
    public void addNewCoachTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/data/coach/add")
                .content(asJsonString(new Coach("Test Name", "test@gmail.com")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("test@gmail.com"))
                .andExpect(jsonPath("$.name").value("Test Name"));
    }

    @Test
    @WithMockUser(roles = {""})
    public void addCoachWithoutAuthorization() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/data/coach/add")
                .content(asJsonString(new Coach("Test Name", "test@gmail.com")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }
}
