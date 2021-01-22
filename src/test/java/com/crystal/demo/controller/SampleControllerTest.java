package com.crystal.demo.controller;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
//@ExtendWith(MockitoJUnit.class)
public class SampleControllerTest {

    /* SampleController sc = new SampleController();
     @Test
     public void testPrintHelloWorld(){
     Assert.assertEquals("Hello World", sc.printHelloWorld() );}*/

    //Use SpringMOckMVC to test this Controller and different REST calls
    private MockMvc mockMvc;

    @InjectMocks
    private SampleController sampleController;

    @Before
    public void setUp() throws Exception{
       //ths buid the mock of the resource
       mockMvc = MockMvcBuilders.standaloneSetup(sampleController).build();
    }
    @Test
    public void testPrintHelloWorld() throws Exception {
        //use the perform
        mockMvc.perform(get("/api/printHello")
        )
                              .andExpect(status().isOk())
                              .andExpect(MockMvcResultMatchers.content().string("Hello World"));
    }

    /*sds*
    can be simplified as
    mockMvc.perform(get("/api/printHello")
           .andExpect(status().isOk())
           .andExpect(content().string("Hello World"))
    /
     */
   @Test
   public void testHelloWorldJson() throws Exception {
       mockMvc.perform(get("/api/json")
                            .accept(MediaType.APPLICATION_JSON)
                          )
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.title", Matchers.is("Greeting")))
               .andExpect(jsonPath("$.value", Matchers.is("Hello Json")));
   }
}