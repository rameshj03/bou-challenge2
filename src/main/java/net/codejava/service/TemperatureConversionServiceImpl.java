package net.codejava.service;

import net.codejava.models.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class TemperatureConversionServiceImpl implements TemperatureConversionService {

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private Environment env;

    @Value("${temperature.api.base.uri}")
    private String restURI;

    /*
    @Autowired
    CityDaoImpl cityDao;


    SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    WeatherDaoImpl weatherDao;

    private List<City> cities;

    @PostConstruct
    public void setUpConfigs() {
        cities = cityDao.findAll();
    }

    public List<Weather> getWeatherRecords() {

        //check on database
        long epoch = System.currentTimeMillis()/1000;
        System.out.println("Epoch time: " + epoch);

        Date date = new Date();
        date.setHours(11);
        date.setMinutes(59);
        date.setSeconds(59);

        List<Temperature> weatherReports = cities.stream().map(city -> {

            Weather weatherItem = getFromDB(city.getLabel(), df.format(date));
            
            if(weatherItem==null){
                String req = "https://api.darksky.net/forecast/2e6f774a44eeca2779413188801c6180/" + city.getLat() + "," + city.getLongt() + "," + epoch + "?exclude=minutely,flags,hourly,currently";

                System.out.println(req);

                weatherItem = restTemplate.getForObject(req, Weather.class);

                weatherItem.setPlaceLabel(city.getLabel());
                weatherItem.setDate(df.format(date));
                weatherDao.save(weatherItem);
            }

            return weatherItem;
        }).collect(Collectors.toList());

        return weatherReports;
    }


    private Weather getFromDB(String location, String date){

        List<Weather> weatherList = weatherDao.findByPlaceLabelAndDate(location, date);

        if(weatherList==null || weatherList.isEmpty()){
            return null;
        }
        else{
            return weatherList.get(0);
        }

    } */

    public List<String> getConvertedTemperatureValues(Temperature temperature) {


        System.out.println("Property: " + temperature.getProperty() + " and Value: " + temperature.getValue());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

        MultiValueMap<String, String> uriVariables = new LinkedMultiValueMap<String, String>();
        uriVariables.add("property", temperature.getProperty());
        uriVariables.add("val", temperature.getValue());

//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(env.getProperty(Constants.API_BASE_URL))
//                .queryParams(uriVariables);


        HttpEntity<?> entity = new HttpEntity<>(uriVariables,headers);

//        https://www.q88.com/WS/Q88WSInternal.asmx/ConvertTemperature?property=Celsius&val=96

        String req = "https://www.q88.com/WS/Q88WSInternal.asmx/ConvertTemperature?property=" + temperature.getProperty() + "&val=" + temperature.getValue();

        System.out.println(req);

//        TemperatureResponse temperatureResponse = restTemplate.getForObject(req, TemperatureResponse.class);

//        ResponseEntity<TemperatureResponse> temperatureResponse = restTemplate.exchange("https://www.q88.com/WS/Q88WSInternal.asmx/ConvertTemperature", HttpMethod.POST, entity, TemperatureResponse.class);
        ResponseEntity<Temperature> temperatureResponse = restTemplate.exchange("https://www.q88.com/WS/Q88WSInternal.asmx/ConvertTemperature?property=" + temperature.getProperty() + "&val=" + temperature.getValue(), HttpMethod.GET,entity, Temperature.class);

        System.out.println(temperatureResponse.getBody());
//        resValues =  temperatureResponse.getBody();

//        HashMap map = temperatureResponse.getBody();



        List<String> convertedValues  = new ArrayList();
//        convertedValues.add((String) resValues.get("Celsius"));
//        convertedValues.add((String) resValues.get("Fahrenheit"));

        return convertedValues;
    }
}
