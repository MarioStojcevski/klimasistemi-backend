package mk.klimasistemi.service;

import mk.klimasistemi.model.AirConditionerBrand;

import java.util.Collection;

public interface IAirConditionerBrandService {
    public Collection<AirConditionerBrand> getAllAirConditionerBrands();
    public AirConditionerBrand findByName(String name);
}
