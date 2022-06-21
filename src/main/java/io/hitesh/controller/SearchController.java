package io.hitesh.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.hitesh.model.Search;
import io.hitesh.service.EmployeeService;
import io.hitesh.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class SearchController {

	@Autowired
	private SearchService service;

	@PostMapping("search")
	public void addPayload(@RequestBody String jsonPayload) throws JsonProcessingException {
		System.out.println(jsonPayload);
		service.saveSearch(jsonPayload);

	}
}
