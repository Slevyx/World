package it.objectmethod.dao;

import java.sql.SQLException;
import java.util.List;

import it.objectmethod.models.City;

public interface ICityDao {

	public City getCityByName(String cityName) throws SQLException;

	public List<City> getCitiesByCountry(String countryCode) throws SQLException;
}
