package net.codejava.service;


import net.codejava.models.Temperature;
import net.codejava.models.TemperatureResponse;

import java.util.List;

public interface TemperatureConversionService {

   public TemperatureResponse getConvertedTemperatureValues(Temperature temperature);

    }

