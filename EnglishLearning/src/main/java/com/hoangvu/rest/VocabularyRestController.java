package com.hoangvu.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoangvu.dao.CategoryRepository;
import com.hoangvu.dto.CategoryDTO;
import com.hoangvu.dto.VocabularyDTO;
import com.hoangvu.entity.Category;
import com.hoangvu.entity.Mean;
import com.hoangvu.entity.Vocabulary;
import com.hoangvu.service.CategoryService;
import com.hoangvu.service.VocabularyService;

@RestController
@RequestMapping(value="/api")
public class VocabularyRestController {
	
	
	@Autowired CategoryRepository categoryRepository;
	
	@RequestMapping(value="/saveVocabulary")
	public String saveVocabulary(@RequestBody() String []arr) {
		Category category = categoryRepository.loadCategoryByName(arr[0]);
		
		Vocabulary vocabulary = new Vocabulary();
		vocabulary.setName(arr[1]);
		vocabulary.setCategory(category);
		List<Mean> means = new ArrayList<Mean>();
		List<Vocabulary>vocabularies = new ArrayList<Vocabulary>();
		
		for (int i = 2; i < arr.length; i++) {
			Mean mean = new Mean();
			mean.setName(arr[i]);
			mean.setCategory(category);
			means.add(mean);
			
		}
		
		vocabulary.setMeans(means);
		vocabularies.add(vocabulary);
		category.setMeans(means);
		category.setVocabularies(vocabularies);
		categoryRepository.save(category);
		
		
		return "Thành công";
	}
}
