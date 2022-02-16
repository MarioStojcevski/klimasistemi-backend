package mk.klimasistemi.controller;

import lombok.RequiredArgsConstructor;
import mk.klimasistemi.model.AirConditioner;
import mk.klimasistemi.model.Response;
import mk.klimasistemi.service.IAirConditionerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rest/airConditioners")
@RequiredArgsConstructor
public class AirConditionerController {

    private final IAirConditionerService airConditionerService;

    @GetMapping("/allPaged/{page}/{size}")
    public ResponseEntity<Response> getAirConditionersPaged(@PathVariable("page") int page,
                                                            @PathVariable("size") int size) {
        Page<AirConditioner> airConditionerPage = airConditionerService.getAllAirConditionersPaged(page, size);
        return ResponseEntity.ok(Response.builder()
                .timeStamp(LocalDateTime.now())
                .data(Map.of("airConditioners", airConditionerPage))
                .size((int) airConditionerPage.getTotalElements())
                .message("Fetched paged air conditioners!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build()
        );
    }

    @GetMapping("/allSorted/{field}")
    public ResponseEntity<Response> getAirConditionersSorted(@PathVariable String field) {
        List<AirConditioner> airConditionerList = airConditionerService.getAllAirConditionersSorted(field);
        return ResponseEntity.ok(Response.builder()
                .timeStamp(LocalDateTime.now())
                .data(Map.of("airConditioners", airConditionerList))
                .size(airConditionerList.size())
                .message("Fetched sorted air conditioners!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build()
        );
    }

    @PostMapping("/add")
    public ResponseEntity<Response> addAirConditioner(@RequestBody @Valid AirConditioner airConditioner) {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(LocalDateTime.now())
                .data(Map.of("added", airConditionerService.createAirConditioner(airConditioner)))
                .message("Air conditioner created!")
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getAirConditionerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(LocalDateTime.now())
                .data(Map.of("airConditioner", airConditionerService.getAirConditionerById(id)))
                .message("Air conditioner retrieved!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build()
        );
    }

    @GetMapping("/getByModelName/{modelName}")
    public ResponseEntity<Response> getAirConditionerByModelName(@PathVariable("modelName") String modelName) {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(LocalDateTime.now())
                .data(Map.of("airConditioner", airConditionerService.getAirConditionerByName(modelName)))
                .message("Air conditioner retrieved!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteAirConditioner(@PathVariable("id") Long id) {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(LocalDateTime.now())
                .data(Map.of("deleted", airConditionerService.deleteAirConditionerById(id)))
                .message("Air conditioner deleted!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build()
        );
    }
}
