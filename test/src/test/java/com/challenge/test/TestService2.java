package com.challenge.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

@RunWith(SpringJUnit4ClassRunner. class)
public class TestService2 {

	@Test
	public void test2() throws MalformedURIException, RestClientException, URISyntaxException, UnsupportedEncodingException {

	//	String fromDate = "2021-05-06";
	//	String toDate = "06-May-2021 23:59:59";
		RestTemplate restTemplate = new RestTemplate();
		//final String baseURL = "http://localhost:8080/getbydate?fromDate=" + fromDate + "&toDate=" + toDate;
		final String baseURL = "http://localhost:8080/getbydate?"+URLEncoder.encode("fromDate=2021-05-06&toDate=06-May-2021 23:59:59", "UTF-8");
		
		HashMap<String, Integer> m = restTemplate.getForEntity(new URI(baseURL), HashMap.class).getBody();
		assertEquals(0, m.size());
	}

}
