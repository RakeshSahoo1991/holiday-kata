/**
 * 
 */
package com.tm.holidaykata.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tm.holidaykata.exception.InvalidYearException;
import com.tm.holidaykata.model.PublicHolidayDto;
import com.tm.holidaykata.model.PublicHolidayType;

/**
 * This class is responsible for all the operation to the repository
 * 
 * @author srake
 *
 */
@Repository
public class HolidayRepositoryImpl implements HolidayRepository {

	/**
	 * This method is to build the holiday list based on year and countrycode.
	 * Here I am preparing data manually.
	 * 
	 * @param year
	 * @param countryCode
	 * @return list of holidaydto
	 */
	@Override
	public List<PublicHolidayDto> findHolidays(Integer year, String countryCode) {

		List<PublicHolidayDto> holidayList = new ArrayList<>();

		PublicHolidayDto holiday1 = new PublicHolidayDto();
		holiday1.setCountryCode(countryCode);
		holiday1.setDate(year + "-03-08");
		holiday1.setLocalName("Internationaler Frauentag");
		holiday1.setName("International Women's Day");
		holiday1.setLunchYear(2019);
		holiday1.setFixed(true);
		holiday1.setGlobal(false);
		holiday1.setType(PublicHolidayType.PUBLIC);
		holiday1.setCountries(getCountryList(countryCode));

		holidayList.add(holiday1);

		PublicHolidayDto holiday2 = new PublicHolidayDto();
		holiday2.setCountryCode(countryCode);
		holiday2.setDate(year + "-06-03");
		holiday2.setLocalName("Fronleichnam");
		holiday2.setName("Corpus Christi");
		holiday2.setLunchYear(2019);
		holiday2.setFixed(true);
		holiday2.setGlobal(false);
		holiday2.setType(PublicHolidayType.PUBLIC);
		holiday2.setCountries(getCountryList(countryCode));

		holidayList.add(holiday2);

		return holidayList;
	}

	private List<String> getCountryList(String countryCode) {
		List<String> countryList = new ArrayList<>();
		countryList.add(countryCode + "-BE");
		countryList.add(countryCode + "-NW");
		return countryList;
	}

}
