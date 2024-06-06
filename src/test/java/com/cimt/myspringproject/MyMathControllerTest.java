package com.cimt.myspringproject;

import com.cimt.myspringproject.controller.MyMathController;
import com.cimt.myspringproject.entity.GCDRequest;
import com.cimt.myspringproject.service.MyMathService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Test class for MyMathController : {@link MyMathController}
 * Author: Harsh, Kshitij
 * Date: 05 June 2024
 */
public class MyMathControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MyMathService mathService;

    @InjectMocks
    private MyMathController mathController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
    }

    /**
     * Test case for getFibonacci() method.
     * It verifies the Fibonacci calculation for a given position.
     */
    @Test
    public void testGetFibonacci() throws Exception {
        when(mathService.calculateFibonacci(10)).thenReturn(55);

        mockMvc.perform(MockMvcRequestBuilders.get("/fibonacci/10"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(55));

        verify(mathService).calculateFibonacci(10);
    }

    /**
     * Test case for calculateGCD() method.
     * It verifies the GCD calculation for two given numbers.
     */
    @Test
    public void testCalculateGCD() throws Exception {
        GCDRequest request = new GCDRequest();
        request.setNum1(42);
        request.setNum2(140);

        when(mathService.calculateGCD(42, 140)).thenReturn(14);

        mockMvc.perform(MockMvcRequestBuilders.post("/gcd")
                        .content("{\"num1\":42,\"num2\":140}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(14));

        verify(mathService).calculateGCD(42, 140);
    }

    /**
     * Test case for getFibonacci() method with position zero.
     * It verifies the Fibonacci calculation for position zero.
     */
    @Test
    public void testGetFibonacciPositionZero() throws Exception {
        when(mathService.calculateFibonacci(0)).thenReturn(0);

        mockMvc.perform(MockMvcRequestBuilders.get("/fibonacci/0"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(0));

        verify(mathService).calculateFibonacci(0);
    }

    /**
     * Test case for calculateGCD() method when num1 is zero.
     * It verifies the GCD calculation when num1 is zero.
     */
    @Test
    public void testCalculateGCDNumOneIsZero() throws Exception {
        GCDRequest request = new GCDRequest();
        request.setNum1(0);
        request.setNum2(140);

        when(mathService.calculateGCD(0, 140)).thenReturn(140);

        mockMvc.perform(MockMvcRequestBuilders.post("/gcd")
                        .content("{\"num1\":0,\"num2\":140}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(140));

        verify(mathService).calculateGCD(0, 140);
    }
}

