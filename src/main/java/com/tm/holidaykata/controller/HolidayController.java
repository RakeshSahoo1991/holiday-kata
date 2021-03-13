/**
 * 
 */
package com.tm.holidaykata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tm.holidaykata.model.PublicHolidayDto;
import com.tm.holidaykata.service.HolidayService;

/**
 * This is the controller class
 * 
 * @author srake
 *
 */
@RestController
@RequestMapping("/Api/v2")
public class HolidayController {

	@Autowired
	HolidayService holidayService;

	/**
	 * This is the rest end point to find out holiday lists
	 * 
	 * @param year
	 * @param countryCode
	 * @return Response entity of type list of holidays
	 */
	@RequestMapping(value = "/PublicHolidays/{year}/{countrycode}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PublicHolidayDto>> getPublicHolidays(@PathVariable("year") String year,
			@PathVariable("countrycode") String countryCode) {
		return new ResponseEntity<List<PublicHolidayDto>>(
				holidayService.getHolidays(Integer.valueOf(year), countryCode), HttpStatus.OK);
	}

	/**
	 * This is the rest end point to find out time difference between 2 dates
	 * 
	 * @param fromTime
	 * @param toTime
	 * @return Response entity of type long
	 */
	@RequestMapping(value = "/TimeDiff/{fromTime}/{toTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> getTimeDiff(@PathVariable("fromTime") String fromTime,
			@PathVariable("toTime") String toTime) {
		return new ResponseEntity<Long>(holidayService.findDateTimeDiff(fromTime, toTime), HttpStatus.OK);
	}

}
