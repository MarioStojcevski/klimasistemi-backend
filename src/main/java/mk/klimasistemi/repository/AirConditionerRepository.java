package mk.klimasistemi.repository;

import mk.klimasistemi.model.AirConditioner;
import mk.klimasistemi.model.dto.FrontEndFilterDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AirConditionerRepository extends JpaRepository<AirConditioner, Long> {

    @Query("SELECT ac FROM AirConditioner ac WHERE ac.price > :#{#filterDto.minPrice} " +
            "AND ac.price < :#{#filterDto.maxPrice} AND ac.averagePower IN :#{#filterDto.powerArray}")
    List<AirConditioner> filterByFilterDto(@Param("filterDto") FrontEndFilterDto filterDto, Sort sort);

    @Query("SELECT ac FROM AirConditioner ac WHERE ac.price > :#{#filterDto.minPrice} " +
            "AND ac.price < :#{#filterDto.maxPrice} AND ac.averagePower IN :#{#filterDto.powerArray}")
    List<AirConditioner> filterByFilterDtoNoSort(@Param("filterDto") FrontEndFilterDto filterDto);

    @Query("SELECT ac FROM AirConditioner ac WHERE ac.price > :#{#filterDto.minPrice} " +
            "AND ac.price < :#{#filterDto.maxPrice}")
    List<AirConditioner> filterByFilterDtoNoPowerArray(@Param("filterDto") FrontEndFilterDto filterDto);

    AirConditioner getAirConditionerByModelName(String modelName);
}
