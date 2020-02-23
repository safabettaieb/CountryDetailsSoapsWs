package com.safa.country.soap.ws.services;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.safa.country.soap.ws.countrydetails.Country;
import com.safa.country.soap.ws.countrydetails.Currency;

@Service
public class CountryService {

	private static final Map<String, Country> countries = new HashMap<>();

	@PostConstruct
	public void PostConstructCountryService() {

		Country tunisia = new Country();
		tunisia.setName("Tunisia");
		tunisia.setCapital("Tunisia");
		tunisia.setPopulation(11853519);
		tunisia.setCurrency(Currency.TND);

		Country france = new Country();
		france.setName("France");
		france.setCapital("Paris");
		france.setPopulation(67064000);
		france.setCurrency(Currency.EUR);

		Country spain = new Country();
		spain.setName("Spain");
		spain.setCapital("Madrid");
		spain.setPopulation(67064000);
		spain.setCurrency(Currency.EUR);

		countries.put(tunisia.getName(), tunisia);
		countries.put(france.getName(), france);
		countries.put(spain.getName(), spain);
	}

	public Country findCountry(String name) {

		return countries.get(name);

	}
}
