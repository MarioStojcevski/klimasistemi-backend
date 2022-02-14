package mk.klimasistemi.repository;

import mk.klimasistemi.model.AirConditionerBrand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirConditionerBrandRepository extends JpaRepository<AirConditionerBrand, Long> {
    public AirConditionerBrand findAirConditionerBrandByName(String name);
}
