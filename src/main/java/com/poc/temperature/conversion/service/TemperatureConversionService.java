package com.poc.temperature.conversion.service;

import com.poc.temperature.conversion.models.Temperature;
import com.poc.temperature.conversion.models.TemperatureResponse;


public interface TemperatureConversionService {

   public TemperatureResponse getConvertedTemperatureValues(Temperature temperature);

    }

