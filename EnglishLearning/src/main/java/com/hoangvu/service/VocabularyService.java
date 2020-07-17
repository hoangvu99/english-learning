package com.hoangvu.service;

import java.util.List;

import com.hoangvu.dto.MeanDTO;
import com.hoangvu.dto.VocabularyDTO;
import com.hoangvu.entity.Mean;

public interface VocabularyService {
	
	public VocabularyDTO getVocabulary(int num, long categoryId);
	
	public String getRandomCorrectMean(List<MeanDTO>meanDTOs);
		
	
	public String[]createQuestion(long categoryId);
	
	public int getVocabularyCount(long categoryId);
	
}
