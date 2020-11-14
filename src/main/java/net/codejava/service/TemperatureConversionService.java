package net.codejava.service;


import net.codejava.models.Temperature;
import net.codejava.models.TemperatureResponse;

import java.util.List;

public interface TemperatureConversionService {

   public List<String> getConvertedTemperatureValues(Temperature temperature);

    }

