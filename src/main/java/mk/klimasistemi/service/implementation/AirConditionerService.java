package mk.klimasistemi.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mk.klimasistemi.model.AirConditioner;
import mk.klimasistemi.model.AirConditionerBrand;
import mk.klimasistemi.repository.AirConditionerBrandRepository;
import mk.klimasistemi.repository.AirConditionerRepository;
import mk.klimasistemi.service.IAirConditionerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AirConditionerService implements IAirConditionerService {

    private final AirConditionerRepository airConditionerRepository;

    @Override
    public AirConditioner createAirConditioner(AirConditioner airConditioner) {
        log.info("Saving new air conditioner: {}", airConditioner.getModelName());
        return this.airConditionerRepository.save(airConditioner);
    }

    @Override
    public List<AirConditioner> getAllAirConditioners() {
        log.info("Fetching all air conditioners...");
        return this.airConditionerRepository.findAll();
    }

    @Override
    public List<AirConditioner> getAllAirConditionersSorted(String field) {
        log.info("Fetching all air conditioners sorted by {}...", field);
        return this.airConditionerRepository.findAll(Sort.by(Sort.Direction.ASC, field)).stream().toList();
    }

    @Override
    public Page<AirConditioner> getAllAirConditionersPaged(int page, int size) {
        log.info("Fetching all air conditioners paged for page {} and size {}...", page, size);
        return this.airConditionerRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public AirConditioner getAirConditionerById(Long id) {
        log.info("Fetching air conditioner by id: {}", id);
        return airConditionerRepository.getById(id);
    }

    @Override
    public AirConditioner getAirConditionerByName(String modelName) {
        log.info("Fetching air conditioner by name: {}", modelName);
        return airConditionerRepository.getAirConditionerByModelName(modelName);
    }

    @Override
    public AirConditioner updateAirConditioner(AirConditioner airConditioner) {
        log.info("Updating air conditioner: {}", airConditioner.getModelName());
        return this.airConditionerRepository.save(airConditioner);
    }

    @Override
    public boolean deleteAirConditionerById(Long id) {
        log.info("Deleting air conditioner: {}", id);
        this.airConditionerRepository.deleteById(id);
        return true;
    }
}
