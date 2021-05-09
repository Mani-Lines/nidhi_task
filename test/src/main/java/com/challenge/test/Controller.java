package com.challenge.test;

import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private Service service;

	@GetMapping(value = "/getbydate")
	public ResponseEntity<Map<String, Integer>> getByDate(@RequestParam String fromDate, @RequestParam String toDate)
			throws ParseException {
		return ResponseEntity.status(HttpStatus.OK).body(service.getDocuments(fromDate, toDate));
	}

}
