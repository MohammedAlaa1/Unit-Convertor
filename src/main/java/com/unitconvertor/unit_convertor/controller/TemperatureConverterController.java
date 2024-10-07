package com.unitconvertor.unit_convertor.controller;

import com.unitconvertor.unit_convertor.model.ConversionRequest;
import com.unitconvertor.unit_convertor.model.ConversionResponse;
import com.unitconvertor.unit_convertor.service.TemperatureConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temperature")
public class TemperatureConverterController {
    @Autowired
    private TemperatureConverterService temperatureConverterService;

    @PostMapping
    public ResponseEntity<ConversionResponse> convertTemperature(@RequestBody ConversionRequest conversionRequest){
        double result = temperatureConverterService.convertTemperature(conversionRequest);
        ConversionResponse response = new ConversionResponse(
                conversionRequest.getValue(),
                conversionRequest.getFromUnit(),
                result,
                conversionRequest.getToUnit()
        );

        return ResponseEntity.ok(response);
    }
}
