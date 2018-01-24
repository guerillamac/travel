package org.guerillamac.data;

import org.guerillamac.entities.Country;

public interface CountryDao {

	Country getCountry(String name);
	void updateCountry(int id);
	void deleteCountry(int id);


}
