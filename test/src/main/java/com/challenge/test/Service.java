package com.challenge.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	DocRepository docRepository;

	@Autowired
	DocReadRepo docreadRepo;

	public Map<String, Integer> getDocuments(String fromDate, String toDate) throws ParseException {

		List<DocRead> list = docreadRepo.find(new SimpleDateFormat("yyyy-MM-dd").parse(fromDate),
				new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(toDate));

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < list.size(); i++) {
			String docName = list.get(i).getDoc().getDocName();
			if (map.containsKey(docName)) {
				map.put(docName, map.get(docName) + 1);
			} else {
				map.put(docName, 1);
			}
		}
		return sortByValue(map);

	}

	public static Map<String, Integer> sortByValue(final Map<String, Integer> wordCounts) {
		return wordCounts.entrySet().stream().sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

}
