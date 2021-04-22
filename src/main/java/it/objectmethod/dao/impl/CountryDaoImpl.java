package it.objectmethod.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.models.Country;
import it.objectmethod.utils.ConnectionFactory;
import it.objectmethod.dao.ICountryDao;

public class CountryDaoImpl implements ICountryDao{

	public List<Country> getCountriesByCountryNameContinentName(String countryName, String continentName) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		List<Country> countriesList = new ArrayList<>();
		Country country = null;
		String sqlQuery = "SELECT Name, Code, Continent, Population, SurfaceArea FROM country WHERE ('' = ? OR UPPER(Name) = ?) AND ('' = ? OR UPPER(Continent) = ?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setString(1, countryName);
		statement.setString(2, countryName);
		statement.setString(3, continentName);
		statement.setString(4, continentName);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			country = new Country();
			country.setName(result.getString("Name"));
			country.setCode(result.getString("Code"));
			country.setContinent(result.getString("Continent"));
			country.setPopulation(result.getInt("Population"));
			country.setSurfaceArea(result.getFloat("SurfaceArea"));
			countriesList.add(country);
		}
		result.close();
		statement.close();
		connection.close();
		return countriesList;
	}

	@Override
	public List<String> getContinents() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		List<String> continentsList = new ArrayList<>();
		String sqlQuery = "SELECT DISTINCT c.Continent FROM country c";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			continentsList.add(result.getString("Continent"));
		}
		result.close();
		statement.close();
		connection.close();
		return continentsList;
	}

	@Override
	public List<Country> getCountriesbyContinentName(String continentName) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		List<Country> countries = new ArrayList<>();
		Country country = null;
		String sqlQuery = "SELECT Name, Code, Continent, Population, SurfaceArea FROM country WHERE Continent = ?";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setString(1, continentName);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			country = new Country();
			country.setName(result.getString("Name"));
			country.setCode(result.getString("Code"));
			country.setContinent(result.getString("Continent"));
			country.setPopulation(result.getInt("Population"));
			country.setSurfaceArea(result.getFloat("SurfaceArea"));
			countries.add(country);
		}
		result.close();
		statement.close();
		connection.close();
		return countries;
	}
}
