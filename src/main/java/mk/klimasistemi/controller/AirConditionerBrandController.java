package mk.klimasistemi.controller;

import lombok.RequiredArgsConstructor;
import mk.klimasistemi.model.Response;
import mk.klimasistemi.service.IAirConditionerBrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("rest/brands")
@RequiredArgsConstructor
public class AirConditionerBrandController {

    private final IAirConditionerBrandService airConditionerBrandService;

    @GetMapping("/listBrands")
    public ResponseEntity<Response> getAirConditionerBrands() {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(LocalDateTime.now())
                .data(Map.of("brands", airConditionerBrandService.getAllAirConditionerBrands()))
                .message("Fetched air conditioner brands!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build()
        );
    }

    @GetMapping("/getBrandByName/{name}")
    public ResponseEntity<Response> getAirConditionerBrands(@PathVariable("name") String name) {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(LocalDateTime.now())
                .data(Map.of("brands", airConditionerBrandService.findByName(name)))
                .message("Fetched air conditioner brands!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build()
        );
    }
}
