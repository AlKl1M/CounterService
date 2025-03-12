package com.alkl1m.counter.controlelr;

import com.alkl1m.counter.service.CounterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class CounterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CounterService counterService;

    @BeforeEach
    void resetCounter() {
        counterService.reset();
    }

    @Test
    void testGetCount_shouldIncrementCounter() throws Exception {
        mockMvc.perform(get("/"))
                .andExpectAll(
                        status().isOk(),
                        content().string("Total visits: 1")
                );

        mockMvc.perform(get("/"))
                .andExpectAll(
                        status().isOk(),
                        content().string("Total visits: 2")
                );
    }

    @Test
    void testReset_shouldResetCounter() throws Exception {
        mockMvc.perform(get("/"));

        mockMvc.perform(get("/reset"))
                .andExpectAll(status().isOk())
                .andExpectAll(content().string("Counter reset!"));
    }

}
