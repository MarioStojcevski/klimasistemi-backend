package mk.klimasistemi.repository;

import mk.klimasistemi.model.AirConditioner;
import mk.klimasistemi.model.dto.FrontEndFilterDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AirConditionerRepository extends JpaRepository<AirConditioner, Long> {

    @Query("select ac from AirConditioner ac where  ac.price>=:minPrice and ac.price<=:maxPrice")
    List<AirConditioner> filterByPrice(Long minPrice,Long maxPrice);

    AirConditioner getAirConditionerByModelName(String modelName);
}
