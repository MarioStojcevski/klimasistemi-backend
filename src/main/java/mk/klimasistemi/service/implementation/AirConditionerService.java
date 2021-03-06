package mk.klimasistemi.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mk.klimasistemi.model.AirConditioner;
import mk.klimasistemi.model.dto.FrontEndFilterDto;
import mk.klimasistemi.repository.AirConditionerRepository;
import mk.klimasistemi.service.IAirConditionerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

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
    public List<AirConditioner> getAllAirConditionersSorted(String field) {
        log.info("Fetching all air conditioners sorted by {}...", field);
        return this.airConditionerRepository.findAll(Sort.by(Sort.Direction.ASC, field)).stream().toList();
    }

    @Override
    public List<AirConditioner> getAllAirConditionersFiltered(FrontEndFilterDto filter) {
        log.info("Fetching all air conditioners filtered by: " +
                        "[sort: {}, minPrice:{}, maxPrice:{}, brand: {}, powerArray:{} ]...",
                filter.getSortBy(),
                filter.getMinPrice(),
                filter.getMaxPrice(),
                filter.getFilterByBrand(),
                Arrays.stream(filter.getPowerArray()).toList());

        List<AirConditioner> airConditioners;

        //sort string and price ranges exist.
        if(!filter.getSortBy().equals("") && filter.getPowerArray().length != 0) {
            airConditioners = this.airConditionerRepository.filterByFilterDto(filter, Sort.by(Sort.Direction.ASC, filter.getSortBy()));
        }
        //price range exists. sort string is "".
        else if(filter.getSortBy().equals("") && filter.getPowerArray().length != 0) {
            airConditioners = this.airConditionerRepository.filterByFilterDtoNoSort(filter);
        }
        //sort string exists. price range is [].
        else if(!filter.getSortBy().equals("") && filter.getPowerArray().length == 0){
            airConditioners = this.airConditionerRepository.filterByPriceSort(filter, Sort.by(Sort.Direction.ASC, filter.getSortBy()));
        }
        //sort string is "". price range is [].
        else {
            airConditioners = this.airConditionerRepository.filterByPrice(filter);
        }

        if(filter.getFilterByBrand() != null) {
            return airConditioners.stream().filter(airConditioner -> airConditioner.getBrand().getId().equals(filter.getFilterByBrand())).toList();
        }

        return airConditioners;
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
    public boolean deleteAirConditionerById(Long id) {
        log.info("Deleting air conditioner: {}", id);
        this.airConditionerRepository.deleteById(id);
        return true;
    }
}
