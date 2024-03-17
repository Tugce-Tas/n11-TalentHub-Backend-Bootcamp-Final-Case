package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.N11TalentHubBackendBootcampFinalCaseApplication;
import feign.FeignIgnore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {N11TalentHubBackendBootcampFinalCaseApplication.class})
@EnableFeignClients(basePackageClasses = com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.RestaurantClient.class)
@ActiveProfiles("test")
class CommentControllerIntegrationTest extends BaseControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Test
    void shouldGetAllComments() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/comments"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }

    @Test
    @Disabled("Works only with existing restaurant id in restaurant service api")
    void shouldSaveComment() throws Exception {
        String request = """
                {
                "text": "55",
                 "score": "ONE",
                 "customerId": 1,
                 "restaurantId": "3524ff4a-a2c0-454f-a569-bf2995b83dc6"
                 }
                 """;


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/comments")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }

    @Test
    void shouldDeleteCommentById() throws Exception {
        long commentId = 3L;

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/v1/comments/{id}", commentId)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }
}