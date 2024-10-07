package com.unitconvertor.unit_convertor.controller;

import com.unitconvertor.unit_convertor.model.ConversionRequest;
import com.unitconvertor.unit_convertor.model.ConversionResponse;
import com.unitconvertor.unit_convertor.service.WeightConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weight")
public class WeightConverterController {
    @Autowired
    private WeightConverterService weightConverterService;

    @PostMapping
    public ResponseEntity<ConversionResponse> convertWeight(@RequestBody ConversionRequest conversionRequest){
        double result = weightConverterService.convertWeight(conversionRequest);
        ConversionResponse response = new ConversionResponse(
                conversionRequest.getValue(),
                conversionRequest.getFromUnit(),
                result,
                conversionRequest.getToUnit()
        );
        return ResponseEntity.ok(response);
    }
}
