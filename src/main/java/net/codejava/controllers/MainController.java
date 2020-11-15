package net.codejava.controllers;

import java.util.Arrays;
import java.util.List;

import net.codejava.models.Temperature;
import net.codejava.models.TemperatureResponse;
import net.codejava.service.TemperatureConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

	@Autowired
	TemperatureConversionService temperatureConversionService;

	@GetMapping("/convert")
	public String showForm(Model model) {
		Temperature temperature = new Temperature();
		model.addAttribute("temperature", temperature);
		
		List<String> listProperty = Arrays.asList("Celsius", "Fahrenheit");
		model.addAttribute("listProperty", listProperty);
		
		return "convert";
	}
	
	@PostMapping("/convert")
	public String doConvert(@ModelAttribute("temperature") Temperature temperature, Model model) {
		System.out.println("Temperature: " + temperature.toString());
		TemperatureResponse listTemperatureResponse = temperatureConversionService.getConvertedTemperatureValues(temperature);
		System.out.println(listTemperatureResponse.toString());
		model.addAttribute("temperatures", listTemperatureResponse);
		return "result";
	}
}
