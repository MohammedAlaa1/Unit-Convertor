package com.unitconvertor.unit_convertor.service;

import com.unitconvertor.unit_convertor.model.ConversionRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LengthConverterService {
    private static final Map<String, Double> lengthConversionFactors = new HashMap<>();
    static {
        //to meters
        lengthConversionFactors.put("millimeter", 0.001);
        lengthConversionFactors.put("centimeter", 0.01);
        lengthConversionFactors.put("meter", 1.0);
        lengthConversionFactors.put("kilometer", 1000.0);
        lengthConversionFactors.put("inch", 0.0254);
        lengthConversionFactors.put("foot", 0.3048);
        lengthConversionFactors.put("yard", 0.9144);
        lengthConversionFactors.put("mile", 1609.34);
    }

    public double convertLength(ConversionRequest request){
        String fromUnit = request.getFromUnit().toLowerCase();
        String toUnit = request.getToUnit().toLowerCase();

        if (!lengthConversionFactors.containsKey(fromUnit) && !lengthConversionFactors.containsKey(toUnit)){
            throw new IllegalArgumentException("Invalid units provided for conversion");
        }

        double valueInMeters = request.getValue() * lengthConversionFactors.get(fromUnit);
        return valueInMeters / lengthConversionFactors.get(toUnit);
    }

}
