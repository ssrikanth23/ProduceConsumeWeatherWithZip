package com.example;



import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

import com.xavient.weatherws.Weather;

@Component
public class WeatherUtility {
	private Map<String,Weather> weatherMap = new HashMap<String,Weather>();
	public WeatherUtility(){
		Weather s1 = new Weather();
		s1.setZip("08820");
		s1.setDescription("Cold");
		s1.setTemperature("60");
		s1.setWeatherStationCity("Edison");
		
		weatherMap.put("08820", s1);
		Weather s2 = new Weather();
		s2.setZip("10038");
		s2.setDescription("Hot");
		s2.setTemperature("90");
		s2.setWeatherStationCity("New York");
		
		weatherMap.put("10038", s2);
	}
	public Weather getWeather(String zip){
		return weatherMap.get(zip);
		
		
	}
} 