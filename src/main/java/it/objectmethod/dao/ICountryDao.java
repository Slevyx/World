package it.objectmethod.dao;

import java.sql.SQLException;
import java.util.List;

import it.objectmethod.models.Country;

public interface ICountryDao {

	public List<Country> getCountriesByCountryNameContinentName(String countryName, String continent) throws SQLException;

	public List<String> getContinents() throws SQLException;

	public List<Country> getCountriesbyContinentName(String continentName) throws SQLException;
}
