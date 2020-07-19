package com.springboot.restful.Exception;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ExceptionTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void should_retrun_400_if_params_is_inValid() throws Exception{
        mockMvc.perform(get("/api/illegalArgumentResponse"))
                .andExpect(status().is(400))
                .andExpect(jsonPath("$.message").value("params fault"));
    }
    @Test
    void shouleReturn404IfResourceNotFound() throws Exception{
        mockMvc.perform(get("/api/ResourceNotFount"))
                .andExpect(status().is(404))
                .andExpect(jsonPath("$.message").value("ResourceNot found"));
    }

}
