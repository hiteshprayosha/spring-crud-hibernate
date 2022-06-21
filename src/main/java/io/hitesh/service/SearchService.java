package io.hitesh.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.hitesh.model.Search;
import io.hitesh.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SearchService {

	@Autowired private SearchRepository repository;

	ObjectMapper mapper = new ObjectMapper();

	public Search saveSearch(String searchData) throws JsonProcessingException {


		Map<String, Object> stringObjectMap = mapper.readValue(searchData, new TypeReference<Map<String, Object>>() {
		});
		Search search = new Search();
		search.setSearchData(stringObjectMap);

		return repository.save(search);
	}
}
