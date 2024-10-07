package com.unitconvertor.unit_convertor.controller;

import com.unitconvertor.unit_convertor.model.ConversionRequest;
import com.unitconvertor.unit_convertor.model.ConversionResponse;
import com.unitconvertor.unit_convertor.service.LengthConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/length")
public class LengthConverterController {

    @Autowired
    private LengthConverterService lengthConverterService;

    @PostMapping
    public ResponseEntity<ConversionResponse> convertLength(@RequestBody ConversionRequest conversionRequest) {
        double result = lengthConverterService.convertLength(conversionRequest);
        ConversionResponse response = new ConversionResponse(
                conversionRequest.getValue(),
                conversionRequest.getFromUnit(),
                result,
                conversionRequest.getToUnit()
        );
        return ResponseEntity.ok(response); // This will return JSON
    }
    }



