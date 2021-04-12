package it.objectmethod.dao;

import java.sql.SQLException;
import java.util.List;

import it.objectmethod.models.City;
import it.objectmethod.models.Country;

public interface IWorldDao {

	public City getCity(String city) throws SQLException;
	
	public List<Country> getCountries(String countryName, String continent) throws SQLException;
	
	public List<Country> getCountriesByContinent(String continentName) throws SQLException;

	public List<City> getCitiesByCountryCode(String countryCode) throws SQLException;
}
