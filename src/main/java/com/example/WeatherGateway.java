package com.example;


import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


import com.cdyne.ws.weatherws.GetCityWeatherByZIP;
import com.cdyne.ws.weatherws.GetCityWeatherByZIPResponse;


public class WeatherGateway extends WebServiceGatewaySupport  {
	
	
		public GetCityWeatherByZIPResponse getCityWeatherByZip(String zipCode) {
			GetCityWeatherByZIP request = new GetCityWeatherByZIP();
			request.setZIP(zipCode);
			//GetCityForecastByZIPResponse response = (GetCityForecastByZIPResponse) getWebServiceTemplate().marshalSendAndReceive(
			//		request, new SoapActionCallback("http://localhost:8088/ws/getStudentResponse"));
			//return response;
			
			GetCityWeatherByZIPResponse response = (GetCityWeatherByZIPResponse) getWebServiceTemplate()
					.marshalSendAndReceive(
							"http://wsf.cdyne.com/WeatherWS/Weather.asmx",
							request,
							new SoapActionCallback("http://ws.cdyne.com/WeatherWS/GetCityWeatherByZIP"));

			return response;
		}
	} 

