package com.unitconvertor.unit_convertor.service;

import com.unitconvertor.unit_convertor.model.ConversionRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TemperatureConverterService {
    private static final Map<String, Double> temperatureConversionFactors = new HashMap<>();
    private static final Map<String, Double> temperatureOffsets = new HashMap<>();

    static {
        // Conversion factors to Celsius
        temperatureConversionFactors.put("celsius", 1.0);         // 1 °C = 1 °C
        temperatureConversionFactors.put("fahrenheit", 5.0 / 9.0); // Factor to convert Fahrenheit to Celsius
        temperatureConversionFactors.put("kelvin", 1.0);          // 1 K = 1 °C (after adjustment)

        // Offsets to convert to Celsius
        temperatureOffsets.put("celsius", 0.0);                  // No offset for Celsius
        temperatureOffsets.put("fahrenheit", 32.0);               // 32 °F is the offset for Fahrenheit
        temperatureOffsets.put("kelvin", 273.15);                 // 273.15 K is the offset for Kelvin
    }

    public double convertTemperature(ConversionRequest request) {
        String fromUnit = request.getFromUnit().toLowerCase();
        String toUnit = request.getToUnit().toLowerCase();

        if (!temperatureConversionFactors.containsKey(fromUnit) || !temperatureConversionFactors.containsKey(toUnit)) {
            throw new IllegalArgumentException("Invalid units provided for conversion");
        }

        // Convert the input temperature to Celsius
        double valueInCelsius = (request.getValue() - temperatureOffsets.get(fromUnit)) * temperatureConversionFactors.get(fromUnit);

        // Convert Celsius to the target unit
        return (valueInCelsius / temperatureConversionFactors.get(toUnit)) + temperatureOffsets.get(toUnit);
    }
}
