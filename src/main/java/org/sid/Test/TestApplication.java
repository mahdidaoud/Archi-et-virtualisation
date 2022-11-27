package org.sid.Test;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class TestApplication {
	static String test() {
		String token = "343eaf0e-5d2f-4488-8879-4996f161cf11";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("X-CMC_PRO_API_KEY", "Bearer" + token);

		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://sandbox-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";

		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);

		String json = result.getBody();
		System.out.println(json);

		String s = "a";
		return s;

	}

	private static ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		test();
		System.out.println("Test_workflow");
	}


}
