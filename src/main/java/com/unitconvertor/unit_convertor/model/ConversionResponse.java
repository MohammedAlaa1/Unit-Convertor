package com.unitconvertor.unit_convertor.model;

public class ConversionResponse {
    private double originalValue;
    private String fromUnit;
    private double convertedValue;
    private String toUnit;

    public ConversionResponse(double originalValue, String fromUnit, double convertedValue, String toUnit) {
        this.originalValue = originalValue;
        this.fromUnit = fromUnit;
        this.convertedValue = convertedValue;
        this.toUnit = toUnit;
    }

    // Getters and Setters
    public double getOriginalValue() { return originalValue; }
    public void setOriginalValue(double originalValue) { this.originalValue = originalValue; }
    public String getFromUnit() { return fromUnit; }
    public void setFromUnit(String fromUnit) { this.fromUnit = fromUnit; }
    public double getConvertedValue() { return convertedValue; }
    public void setConvertedValue(double convertedValue) { this.convertedValue = convertedValue; }
    public String getToUnit() { return toUnit; }
    public void setToUnit(String toUnit) { this.toUnit = toUnit; }
}

