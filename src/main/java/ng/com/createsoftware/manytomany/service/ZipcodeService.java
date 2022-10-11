package ng.com.createsoftware.manytomany.service;

import ng.com.createsoftware.manytomany.dto.request.ZipcodeRequestDto;
import ng.com.createsoftware.manytomany.model.Zipcode;

import java.util.List;

public interface ZipcodeService {

    Zipcode addZipcode(ZipcodeRequestDto zipcodeRequestDto);
    List<Zipcode> getZipcodes();

    Zipcode getZipcode(Long zipcodeId);

    Zipcode deleteZipcode(Long zipcodeId);

    Zipcode editZipcode(Long zipcoode, ZipcodeRequestDto zipcodeRequestDto);

    Zipcode addCityToZipcode(Long zipcodeId, Long cityId);

    Zipcode removeCityFromZipcode(Long zipcodeId);
}
