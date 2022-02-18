package mk.klimasistemi.repository;

import mk.klimasistemi.model.AirConditioner;
import mk.klimasistemi.model.dto.FrontEndFilterDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AirConditionerRepository extends JpaRepository<AirConditioner, Long> {

    // Filter when sort string is != "" and kW array != [].
    @Query("SELECT ac FROM AirConditioner ac WHERE " +
            "ac.price > :#{#filterDto.minPrice} AND " +
            "ac.price < :#{#filterDto.maxPrice} AND " +
            "ac.averagePower IN :#{#filterDto.powerArray}")
    List<AirConditioner> filterByFilterDto(@Param("filterDto") FrontEndFilterDto filterDto, Sort sort);

    // Filter when sort string == "" and kW array != [].
    @Query("SELECT ac FROM AirConditioner ac WHERE " +
            "ac.price > :#{#filterDto.minPrice} AND " +
            "ac.price < :#{#filterDto.maxPrice} AND " +
            "ac.averagePower IN :#{#filterDto.powerArray}")
    List<AirConditioner> filterByFilterDtoNoSort(@Param("filterDto") FrontEndFilterDto filterDto);

    // Filter when sort string == "" and kW array == []. Therefore only filter by price
    @Query("SELECT ac FROM AirConditioner ac WHERE " +
            "ac.price > :#{#filterDto.minPrice} AND " +
            "ac.price < :#{#filterDto.maxPrice}")
    List<AirConditioner> filterByPrice(@Param("filterDto") FrontEndFilterDto filterDto);

    // Filter when sort string != "" and kW array == [].
    @Query("SELECT ac FROM AirConditioner ac WHERE " +
            "ac.price > :#{#filterDto.minPrice} AND " +
            "ac.price < :#{#filterDto.maxPrice}")
    List<AirConditioner> filterByPriceSort(@Param("filterDto") FrontEndFilterDto filterDto, Sort sort);

    AirConditioner getAirConditionerByModelName(String modelName);
}
