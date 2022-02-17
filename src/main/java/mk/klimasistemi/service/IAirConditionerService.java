package mk.klimasistemi.service;

import mk.klimasistemi.model.AirConditioner;
import mk.klimasistemi.model.dto.FrontEndFilterDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IAirConditionerService {
    AirConditioner createAirConditioner(AirConditioner airConditioner);
    List<AirConditioner> getAllAirConditioners();
    List<AirConditioner> getAllAirConditionersSorted(String field);
    List<AirConditioner> getAllAirConditionersFiltered(FrontEndFilterDto filter);
    Page<AirConditioner> getAllAirConditionersPaged(int page, int size);
    AirConditioner getAirConditionerById(Long id);
    AirConditioner getAirConditionerByName(String modelName);
    AirConditioner updateAirConditioner(AirConditioner airConditioner);
    boolean deleteAirConditionerById(Long id);
}
