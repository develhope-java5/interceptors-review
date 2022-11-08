package com.develhope.java5.hellomvctest.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FruitControllerTests {
    @Autowired
    private FruitController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        assertNotNull(controller);
    }

    @Test
    void testEmptyDatabaseGetAll() throws Exception {
        mockMvc.perform(get("/fruits/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("[]"));
    }

    @Test
    @DirtiesContext
    void testInsertOne() throws Exception {
        String requestBody = "{ \"name\": \"Apple\", \"quantity\": 10}";
        String expectedResponseBody = "{\"id\":1,\"name\":\"Apple\",\"quantity\":10}";

        mockMvc.perform(post("/fruits/")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isCreated())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string(expectedResponseBody));
    }

    @Test
    void testInsertWithoutBody() throws Exception {
        mockMvc.perform(post("/fruits/")
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().is4xxClientError());
    }

    // TODO: Trovare una soluzione perché "name" sia un campo necessario nella richiesta
    @Test
    void testInsertWithoutName() throws Exception {
        String requestBody = "{ \"quantity\": 10 }";

        mockMvc.perform(post("/fruits/")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().is4xxClientError());
    }
}
