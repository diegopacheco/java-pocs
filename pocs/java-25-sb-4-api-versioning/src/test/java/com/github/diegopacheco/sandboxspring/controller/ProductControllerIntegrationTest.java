package com.github.diegopacheco.sandboxspring.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class ProductControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testVersion1Endpoint() throws Exception {
        mockMvc.perform(get("/api/products/search")
                .param("query", "laptop")
                .header("Version", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Laptop")))
                .andExpect(jsonPath("$[0].price", is(999.99)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Laptop Pro")))
                .andExpect(jsonPath("$[1].price", is(1299.99)))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[2].name", is("Laptop Air")))
                .andExpect(jsonPath("$[2].price", is(899.99)));
    }

    @Test
    public void testVersion2Endpoint() throws Exception {
        mockMvc.perform(get("/api/products/search")
                .param("query", "laptop")
                .param("limit", "5")
                .header("Version", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.products", hasSize(3)))
                .andExpect(jsonPath("$.totalResults", is(3)))
                .andExpect(jsonPath("$.limit", is(5)))
                .andExpect(jsonPath("$.products[0].id", is(1)))
                .andExpect(jsonPath("$.products[0].name", is("Laptop")))
                .andExpect(jsonPath("$.products[0].price", is(999.99)))
                .andExpect(jsonPath("$.products[0].description", is("High performance laptop")))
                .andExpect(jsonPath("$.products[0].category", is("Electronics")))
                .andExpect(jsonPath("$.products[1].id", is(2)))
                .andExpect(jsonPath("$.products[1].name", is("Laptop Pro")))
                .andExpect(jsonPath("$.products[1].price", is(1299.99)))
                .andExpect(jsonPath("$.products[1].description", is("Professional grade laptop")))
                .andExpect(jsonPath("$.products[1].category", is("Electronics")))
                .andExpect(jsonPath("$.products[2].id", is(3)))
                .andExpect(jsonPath("$.products[2].name", is("Laptop Air")))
                .andExpect(jsonPath("$.products[2].price", is(899.99)))
                .andExpect(jsonPath("$.products[2].description", is("Lightweight and portable")))
                .andExpect(jsonPath("$.products[2].category", is("Electronics")));
    }

    @Test
    public void testVersion2EndpointWithDefaultLimit() throws Exception {
        mockMvc.perform(get("/api/products/search")
                .param("query", "laptop")
                .header("Version", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.products", hasSize(3)))
                .andExpect(jsonPath("$.totalResults", is(3)))
                .andExpect(jsonPath("$.limit", is(10)));
    }

    @Test
    public void testDefaultVersionEndpoint() throws Exception {
        mockMvc.perform(get("/api/products/search")
                .param("query", "laptop"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Laptop")))
                .andExpect(jsonPath("$[0].price", is(999.99)));
    }

    @Test
    public void testVersion1HasNoExtraFields() throws Exception {
        mockMvc.perform(get("/api/products/search")
                .param("query", "laptop")
                .header("Version", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description").doesNotExist())
                .andExpect(jsonPath("$[0].category").doesNotExist());
    }

    @Test
    public void testVersion2HasAllFields() throws Exception {
        mockMvc.perform(get("/api/products/search")
                .param("query", "laptop")
                .header("Version", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.products[0].description").exists())
                .andExpect(jsonPath("$.products[0].category").exists());
    }
}
