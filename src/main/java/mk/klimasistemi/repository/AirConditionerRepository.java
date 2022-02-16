package mk.klimasistemi.repository;

import mk.klimasistemi.model.AirConditioner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirConditionerRepository extends JpaRepository<AirConditioner, Long> {
    AirConditioner getAirConditionerByModelName(String modelName);
}
