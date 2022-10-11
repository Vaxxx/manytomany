package ng.com.createsoftware.manytomany.service;


import ng.com.createsoftware.manytomany.dto.request.CityRequestDto;
import ng.com.createsoftware.manytomany.model.City;

import java.util.List;

public interface CityService {
    City addCity(CityRequestDto cityRequestDto);

    List<City> getCities();

    City getCity(Long cityId);

    City deleteCity(Long cityId);

    City editCity(Long cityId, CityRequestDto cityRequestDto);
}
