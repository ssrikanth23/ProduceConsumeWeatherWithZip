package com.example;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.cdyne.ws.weatherws.GetCityWeatherByZIPResponse;
import com.xavient.weatherws.Weather;

@SpringBootApplication
public class RunSoapClient {
	
	
	public static void main(String[] args) {
		SpringApplication.run(RunSoapClient.class, args);
		

	      
	        
//	    WeatherGateway client = ctx.getBean(WeatherGateway.class);
//		System.out.println("For Zip Code : 08820");
//		GetCityWeatherByZIPResponse response = client.getCityWeatherByZip("08820");
//		System.out.println("Weather City is:"+response.getGetCityWeatherByZIPResult().getCity());
//		System.out.println("Weather Station City:"+response.getGetCityWeatherByZIPResult().getWeatherStationCity());
//		System.out.println("Description:"+response.getGetCityWeatherByZIPResult().getDescription());
//		System.out.println("Temperature :"+response.getGetCityWeatherByZIPResult().getTemperature());
	//	getWeatherInfo("08820");
	
	
			
	}
	
	public static Weather getWeatherInfo(String zip){

		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ClientAppConfig.class);
        ctx.refresh();
        WeatherGateway client = ctx.getBean(WeatherGateway.class);
			
			GetCityWeatherByZIPResponse response = client.getCityWeatherByZip(zip);
//			System.out.println("Weather City is:"+response.getGetCityWeatherByZIPResult().getCity());
//			System.out.println("Weather Station City:"+response.getGetCityWeatherByZIPResult().getWeatherStationCity());
//			System.out.println("Description:"+response.getGetCityWeatherByZIPResult().getDescription());
//			System.out.println("Temperature :"+response.getGetCityWeatherByZIPResult().getTemperature());
			
			Weather s1 = new Weather();
			//s1.setZip("08820");
			s1.setDescription(response.getGetCityWeatherByZIPResult().getDescription());
			s1.setTemperature(response.getGetCityWeatherByZIPResult().getTemperature());
			s1.setWeatherStationCity(response.getGetCityWeatherByZIPResult().getWeatherStationCity());
		    
		return s1;
		
		
	}
} 