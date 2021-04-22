package it.objectmethod.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.dao.ICityDao;
import it.objectmethod.models.City;
import it.objectmethod.utils.ConnectionFactory;

public class CityDaoImpl implements ICityDao{

	@Override
	public City getCityByName(String cityName) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		City city = null;
		String sqlQuery = "SELECT * FROM city WHERE UPPER(Name) = ?";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setString(1, cityName);
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
	public List<City> getCitiesByCountry(String countryCode) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		List<City> cities = new ArrayList<>();
		City city = null;
		String sqlQuery = "SELECT * FROM city WHERE CountryCode = ?";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setString(1, countryCode);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			city = new City();
			city.setId(result.getInt("ID"));
			city.setName(result.getString("Name"));
			city.setCountryCode(result.getString("CountryCode"));
			city.setDistrict(result.getString("District"));
			city.setPopulation(result.getInt("Population"));
			cities.add(city);
		}
		result.close();
		statement.close();
		connection.close();
		return cities;
	}
}
