package mk.klimasistemi.service;

import mk.klimasistemi.model.AirConditionerBrand;

import java.util.Collection;

public interface IAirConditionerBrandService {
    Collection<AirConditionerBrand> getAllAirConditionerBrands();
    AirConditionerBrand findByName(String name);
    String getBrandImageById(Long id);
}
