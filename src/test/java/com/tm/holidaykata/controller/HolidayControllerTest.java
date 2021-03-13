/**
 * 
 */
package com.tm.holidaykata.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class is responsible for controller test without mocking the Service
 * response as most of the exceptions are thrown from service
 * 
 * @author srake
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class HolidayControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@Order(1)
	void shouldReturnHolidayList() throws Exception {

		mockMvc.perform(get("/Api/v2/PublicHolidays/{year}/{countrycode}", "2021", "DE")).andExpect(status().isOk());
	}

	@Test
	@Order(2)
	void shouldReturn409() throws Exception {

		mockMvc.perform(get("/Api/v2/PublicHolidays/{year}/{countrycode}", "2031", "DE"))
				.andExpect(status().isConflict());

	}

	@Test
	@Order(3)
	void shouldReturnDateDiff() throws Exception {

		mockMvc.perform(
				get("/Api/v2/TimeDiff/{fromTime}/{toTime}", "2011-12-03T10:15:30+01:00", "2012-12-03T10:15:30+01:00"))
				.andExpect(status().isOk());
	}

	@Test
	@Order(2)
	void shouldReturn409ForDateDiff() throws Exception {

		mockMvc.perform(
				get("/Api/v2/TimeDiff/{fromTime}/{toTime}", "2011-12-03T10:15:30+01:00", "2011-12-0310:15:30+01:00"))
				.andExpect(status().isConflict());

	}

}
