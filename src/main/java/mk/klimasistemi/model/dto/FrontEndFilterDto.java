package mk.klimasistemi.model.dto;

import lombok.Data;

@Data

public class FrontEndFilterDto {
    Long maxPrice;
    Long minPrice;
    Long[] powerArray;
    String sortBy;
}
