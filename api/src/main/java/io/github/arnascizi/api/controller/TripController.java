package io.github.arnascizi.api.controller;

import io.github.arnascizi.api.common.Constant;
import io.github.arnascizi.bl.dto.TripDto;
import io.github.arnascizi.bl.payload.TripRequest;
import io.github.arnascizi.bl.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constant.TRIP_ENDPOINT)
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;

    @PostMapping(Constant.CALCULATE)
    public ResponseEntity<TripDto> recommendItemsForTrip(@RequestBody TripRequest request) {
        return new ResponseEntity<>(tripService.evaluateItemsForTrip(request),
                HttpStatus.OK);
    }
}
