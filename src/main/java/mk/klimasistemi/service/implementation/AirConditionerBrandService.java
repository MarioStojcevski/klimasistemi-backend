package mk.klimasistemi.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mk.klimasistemi.model.AirConditionerBrand;
import mk.klimasistemi.repository.AirConditionerBrandRepository;
import mk.klimasistemi.service.IAirConditionerBrandService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AirConditionerBrandService implements IAirConditionerBrandService {

    private final AirConditionerBrandRepository airConditionerBrandRepository;

    @Override
    public Collection<AirConditionerBrand> getAllAirConditionerBrands() {
        return this.airConditionerBrandRepository.findAll().stream().toList();
    }

    @Override
    public AirConditionerBrand findByName(String name) {
        return this.airConditionerBrandRepository.findAirConditionerBrandByName(name);
    }

    @Override
    public String getBrandImageById(Long id) {
        return null;
    }

}
