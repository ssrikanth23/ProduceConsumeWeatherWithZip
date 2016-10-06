package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.xavient.weatherws.GetWeatherRequest;
import com.xavient.weatherws.GetWeatherResponse;
import com.xavient.weatherws.Weather;

@Endpoint
public class WeatherEndpoint {
	private static final String NAMESPACE_URI = "http://xavient.com/WeatherWS";
	
	@Autowired
	private WeatherUtility weatherUtility;
	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getWeatherRequest")
	@ResponsePayload
	public GetWeatherResponse getWeatherDetails(@RequestPayload GetWeatherRequest request) {
		GetWeatherResponse response = new GetWeatherResponse();
		System.out.println("zip:"+request.getZip());

		//response.setWeather(weatherUtility.getWeather(request.getZip()));
		response.setWeather(RunSoapClient.getWeatherInfo(request.getZip()));
		return response;
	}
} 
