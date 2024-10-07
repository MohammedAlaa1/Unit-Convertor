package com.unitconvertor.unit_convertor.service;

import com.unitconvertor.unit_convertor.model.ConversionRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeightConverterService {
    private static final Map<String, Double> weightConversionFactors = new HashMap<>();

    static {
    //to grams
        weightConversionFactors.put("milligram", 0.001);
        weightConversionFactors.put("gram", 1.0);
        weightConversionFactors.put("kilogram", 1000.0);
        weightConversionFactors.put("ounce", 28.3495);
        weightConversionFactors.put("pound", 453.592);
    }
    public double convertWeight(ConversionRequest request){
        String fromUnit = request.getFromUnit().toLowerCase();
        String toUnit = request.getToUnit().toLowerCase();

        if(!weightConversionFactors.containsKey(fromUnit) && !weightConversionFactors.containsKey(toUnit)){
            throw new IllegalArgumentException("Invalid units provided for conversion");
        }

        double ValueInGrams = request.getValue() * weightConversionFactors.get(fromUnit);
        return ValueInGrams / weightConversionFactors.get(toUnit);
    }

}
