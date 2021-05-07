package com.challenge.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	DocRepository docRepository;

	@Autowired
	DocReadRepo docreadRepo;

	@GetMapping(value = "/getbydate")
	public Map<Integer, Integer> getByDate(@RequestParam String fromDate, @RequestParam String toDate)
			throws ParseException {

		System.out.println(fromDate);
		System.out.println(toDate);

		System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(fromDate));
		System.out.println(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(toDate));

		List<DocRead> list = docreadRepo.find(new SimpleDateFormat("yyyy-MM-dd").parse(fromDate),
				new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(toDate));

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < list.size(); i++) {
			int docId = list.get(i).getDoc().getDocId();
			if (map.containsKey(docId)) {
				map.put(docId, map.get(docId) + 1);
			} else {
				map.put(docId, 1);
			}
		}
		return sortByValue(map);

	}

	public static Map<Integer, Integer> sortByValue(final Map<Integer, Integer> wordCounts) {

		return wordCounts.entrySet().stream().sorted((Map.Entry.<Integer, Integer>comparingByValue().reversed()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

}
