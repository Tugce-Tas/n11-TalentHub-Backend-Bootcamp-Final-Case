package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.N11TalentHubBackendBootcampFinalCaseApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {N11TalentHubBackendBootcampFinalCaseApplication.class})
class CustomerControllerTest extends BaseControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Test
    void shouldGetAllCustomers() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }

    @Test
    void shouldSaveCustomer() throws Exception {
        String request = """
                {
                  "name": "name1",
                  "surname": "surname1",
                  "longitude": "10.1",
                  "latitude": "20.1"
                }""";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/customers")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }

    @Test
    void shouldUpdateCustomerById() throws Exception {

        String request = """
                  {
                    "name": "string",
                    "surname": "string",
                    "longitude": 10.0,
                    "latitude": 10.0
                }""";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .put("/api/v1/customers/9")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

    }

    @Test
    void shouldSuggestRestaurantsById() throws Exception {

        long customerId = 5;

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/customers/suggested-restaurants/{id}", customerId)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

    }

    @Test
    void shouldDeleteCustomerById() throws Exception {
        long customerId = 1;

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/v1/customers/{id}", customerId)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }


}