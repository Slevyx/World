package it.objectmethod.dao;

import java.util.List;

import it.objectmethod.models.City;

public interface ICityDao {

	public City getCityByName(String cityName);

	public List<City> getCitiesByCountry(String countryCode);
}
