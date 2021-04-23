package it.objectmethod.dao;

import java.util.List;

import it.objectmethod.models.Country;

public interface ICountryDao {

	public List<Country> getCountriesByCountryNameContinentName(String countryName, String continent);

	public List<String> getContinents();

	public List<Country> getCountriesbyContinentName(String continentName);
}
