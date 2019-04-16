package com.smart.reads.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.reads.api.SmartReadApp;
import com.smart.reads.api.model.MeterRead;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SmartReadApp.class)
@WebAppConfiguration
public class SmartReadAppTests {
   
   protected MockMvc mvc;
   
   @Autowired
   WebApplicationContext webApplicationContext;

   @Before
   public void setUp() {
      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
   }
   
   protected <T> T mapFromJson(String json, Class<T> clazz)
      throws JsonParseException, JsonMappingException, IOException {
      
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.readValue(json, clazz);
   }
   
   @Test
   public void givenValidAccountNumber_thenReturnMeterReading() throws Exception {
      String uri = "/api/smart/reads/1";
      
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      MeterRead meterRead = mapFromJson(content, MeterRead.class);
      assertTrue(meterRead != null);
      assertEquals(30482, meterRead.getGasRead());
      assertEquals(10026, meterRead.getElectrictyRead());
   }
   
   @Test
   public void givenNonExistAccountNumber_thenReturnNotFound() throws Exception {
      String uri = "/api/smart/reads/3";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(404, status);
      
   }
   
   @Test
   public void givenInValidAccountNUmber_thenReturnBadRequest() throws Exception {
      String uri = "/api/smart/reads/test";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(400, status);
      
   }
   
}
