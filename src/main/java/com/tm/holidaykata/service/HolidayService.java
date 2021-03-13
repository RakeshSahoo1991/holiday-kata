/**
 * 
 */
package com.tm.holidaykata.service;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tm.holidaykata.exception.InvalidYearException;
import com.tm.holidaykata.exception.TimeDiffException;
import com.tm.holidaykata.model.PublicHolidayDto;
import com.tm.holidaykata.repository.HolidayRepository;

/**
 * This is the service level class of holiday service
 * @author srake
 *
 */
@Service
public class HolidayService {

	@Value("${year.limit.upper}")
	private Integer upperLimit;

	@Value("${year.limit.lower}")
	private Integer lowerLimit;

	@Autowired
	HolidayRepository repository;

	/**
	 * This service level method to find out holidays
	 * @param year
	 * @param countryCode
	 * @return list of holidaydto
	 * @throws InvalidYearException
	 */
	public List<PublicHolidayDto> getHolidays(Integer year, String countryCode) throws InvalidYearException {

		List<PublicHolidayDto> holidayDto = null;
		if (year >= lowerLimit && year <= upperLimit)
			holidayDto = repository.findHolidays(year,countryCode);
		else
			throw new InvalidYearException("Please provie a valida year between " + lowerLimit + " - " + upperLimit);

		return holidayDto;

	}

	/**
	 * This method is responsible to find out difference between 2 dates in hours
	 * @param fromDate
	 * @param toDate
	 * @return time difference long value
	 * @throws TimeDiffException
	 */
	public Long findDateTimeDiff(String fromDate, String toDate) throws TimeDiffException {
		long timeDiff = 0;
		try {
			ZonedDateTime fromDateTime = ZonedDateTime.parse(fromDate);
			ZonedDateTime toDateTime = ZonedDateTime.parse(toDate);

			timeDiff = ChronoUnit.HOURS.between(fromDateTime, toDateTime);
		} catch (Exception e) {
			throw new TimeDiffException("Error Calculating the DateTimeDiff.Please provide date in correct format");
		}

		return timeDiff;

	}

}
