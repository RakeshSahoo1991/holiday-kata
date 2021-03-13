/**
 * 
 */
package com.tm.holidaykata.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tm.holidaykata.model.PublicHolidayDto;

/**
 * @author srake
 *
 */
@Component
public interface HolidayRepository {
	
	public List<PublicHolidayDto> findHolidays(Integer year,String countryCode);

}
