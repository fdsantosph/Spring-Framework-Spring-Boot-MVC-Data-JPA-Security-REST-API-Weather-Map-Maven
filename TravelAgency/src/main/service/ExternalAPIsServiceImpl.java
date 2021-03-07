package main.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.externalapi.model.myip.MyIP;
import main.externalapi.model.openweathermap.OpenWeatherMap;

@Service
public class ExternalAPIsServiceImpl implements ExternalAPIsService {

	private static final String OPENWEATHERMAP_API_KEY = "5e92323cf61020b7890daf20cf5fe397";
	private static final String OPENWEATHERMAP_ADDRESS = "http://api.openweathermap.org/data/2.5/";
	
	@Override
	public OpenWeatherMap getData(HttpServletRequest request) {

		String city = "Manila";
		OpenWeatherMap openWeatherMap = getWeatherForCity(city);
		return openWeatherMap;
	}

	
	
	
	private OpenWeatherMap getWeatherForCity(String city) {
		StringBuilder url = new StringBuilder();
		url.append(OPENWEATHERMAP_ADDRESS).append("weather?q=").append("Manila").append("&units=metric").append("&appid=").append("5e92323cf61020b7890daf20cf5fe397");

		RestTemplate restTemplate = new RestTemplate();
		OpenWeatherMap openWeatherMap = new OpenWeatherMap();
		
		try {
			String response = restTemplate.getForObject(url.toString(), String.class);
			ObjectMapper mapper = new ObjectMapper();
			openWeatherMap = mapper.readValue(response, OpenWeatherMap.class);
		} catch (JsonProcessingException | HttpClientErrorException e) {
			return null;
		}
		
		return openWeatherMap;
	}

	
}
