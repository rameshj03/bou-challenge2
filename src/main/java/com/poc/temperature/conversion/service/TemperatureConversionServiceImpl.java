package com.poc.temperature.conversion.service;

import com.poc.temperature.conversion.models.Temperature;
import com.poc.temperature.conversion.models.TemperatureResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class TemperatureConversionServiceImpl implements TemperatureConversionService {

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private Environment env;

    @Value("${temperature.api.base.uri}")
    private String restURI;

    @Async
    public TemperatureResponse getConvertedTemperatureValues(Temperature temperature) {


        System.out.println("Property: " + temperature.getProperty() + " and Value: " + temperature.getValue());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

        MultiValueMap<String, String> uriVariables = new LinkedMultiValueMap<String, String>();
        uriVariables.add("property", temperature.getProperty());
        uriVariables.add("val", temperature.getValue());

        HttpEntity<?> entity = new HttpEntity<>(uriVariables,headers);

        String req = "https://www.q88.com/WS/Q88WSInternal.asmx/ConvertTemperature?property=" + temperature.getProperty() + "&val=" + temperature.getValue();

        System.out.println(req);

//        TemperatureResponse temperatureResponse = restTemplate.getForObject(req, TemperatureResponse.class);

//        ResponseEntity<TemperatureResponse> temperatureResponse = restTemplate.exchange("https://www.q88.com/WS/Q88WSInternal.asmx/ConvertTemperature", HttpMethod.POST, entity, TemperatureResponse.class);
//        ResponseEntity<TemperatureResponse> temperatureResponse = restTemplate.exchange("https://www.q88.com/WS/Q88WSInternal.asmx/ConvertTemperature?property=" + temperature.getProperty() + "&val=" + temperature.getValue(), HttpMethod.GET,entity, TemperatureResponse.class);

        Object temperatureResponse = restTemplate.postForObject("https://www.q88.com/WS/Q88WSInternal.asmx/ConvertTemperature", entity,Object.class);

        System.out.println(temperatureResponse);

       Map<String, String> tempAPIReponse = (Map)temperatureResponse ;


      TemperatureResponse resp = new TemperatureResponse();
       resp.setCelsius(tempAPIReponse.get("Celsius"));
       resp.setFahrenheit(tempAPIReponse.get("Fahrenheit"));

        System.out.println("Celsius:" + resp.getCelsius());
        System.out.println("Fahrenheit:" + resp.getFahrenheit());

        return resp;
    }
}
