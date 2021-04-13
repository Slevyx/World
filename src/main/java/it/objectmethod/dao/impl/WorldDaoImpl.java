package it.objectmethod.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.dao.IWorldDao;
import it.objectmethod.models.City;
import it.objectmethod.models.Country;
import it.objectmethod.utils.ConnectionFactory;

public class WorldDaoImpl implements IWorldDao{

	@Override
	public City getCity(String inputCity) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		City city = null;
		String sqlQuery = "SELECT * FROM city WHERE UPPER(Name) = ?";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setString(1, inputCity);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			city = new City();
			city.setId(result.getInt("ID"));
			city.setName(result.getString("Name"));
			city.setCountryCode(result.getString("CountryCode"));
			city.setDistrict(result.getString("District"));
			city.setPopulation(result.getInt("Population"));
		}
		result.close();
		statement.close();
		connection.close();
		return city;
	}

	@Override
	public List<Country> getCountries(String countryName, String continent) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		List<Country> countryList = new ArrayList<>();
		Country country = null;
		String sqlQuery = "SELECT Name, Code, Continent, Population, SurfaceArea FROM country WHERE ('' = ? OR UPPER(Name) = ?) AND ('' = ? OR UPPER(Continent) = ?)";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setString(1, countryName);
		statement.setString(2, countryName);
		statement.setString(3, continent);
		statement.setString(4, continent);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			country = new Country();
			country.setName(result.getString("Name"));
			country.setCode(result.getString("Code"));
			country.setContinent(result.getString("Continent"));
			country.setPopulation(result.getInt("Population"));
			country.setSurfaceArea(result.getFloat("SurfaceArea"));
			countryList.add(country);
		}
		result.close();
		statement.close();
		connection.close();
		return countryList;
	}

	@Override
	public List<Country> getCountriesByContinent(String continentName) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		List<Country> countryList = new ArrayList<>();
		Country country = null;
		String sqlQuery = "SELECT Name, Population, Code FROM country WHERE UPPER(Continent) = ?";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setString(1, continentName);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			country = new Country();
			country.setName(result.getString("Name"));
			country.setCode(result.getString("Code"));
			country.setPopulation(result.getInt("Population"));
			countryList.add(country);
		}
		result.close();
		statement.close();
		connection.close();
		return countryList;
	}

	@Override
	public List<City> getCitiesByCountryCode(String countryCode) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		List<City> citiesList = new ArrayList<>();
		City city = null;
		String sqlQuery = "SELECT Name, Population FROM city WHERE UPPER(CountryCode) = ?";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setString(1, countryCode);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			city = new City();
			city.setName(result.getString("Name"));
			city.setPopulation(result.getInt("Population"));
			citiesList.add(city);
		}
		result.close();
		statement.close();
		connection.close();
		return citiesList;
	}
}
