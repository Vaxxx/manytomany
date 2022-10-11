package ng.com.createsoftware.manytomany.controller;

import ng.com.createsoftware.manytomany.dto.request.CityRequestDto;
import ng.com.createsoftware.manytomany.model.City;
import ng.com.createsoftware.manytomany.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public ResponseEntity<City> addCity(@RequestBody final CityRequestDto cityRequestDto){
        City city = cityService.addCity(cityRequestDto);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<City> getCityById(@PathVariable final Long id){
        City city = cityService.getCity(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<City>> getCities(){
        List<City> cities = cityService.getCities();
        return new ResponseEntity<List<City>>(cities, HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable final Long id){
        City city = cityService.deleteCity(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
    @PostMapping("/edit/id")
    public ResponseEntity<City> editCity(@RequestBody final CityRequestDto cityRequestDto, @PathVariable final Long id){
        City city = cityService.editCity(id, cityRequestDto);
        return  new ResponseEntity<>(city, HttpStatus.OK);

    }
}
