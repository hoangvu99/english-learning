package com.hoangvu.service.iml;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hoangvu.dao.MeanRepository;
import com.hoangvu.dao.VocabularyRepository;
import com.hoangvu.dto.MeanDTO;
import com.hoangvu.dto.VocabularyDTO;
import com.hoangvu.entity.Mean;
import com.hoangvu.entity.Vocabulary;
import com.hoangvu.service.MeanService;
import com.hoangvu.service.VocabularyService;
@Service
public class VocabularyServiceImplement implements VocabularyService{
	
	@Autowired
	VocabularyRepository vocabularyRepository;
	
	@Autowired
	Random random;
	
	@Autowired
	MeanRepository meanRepository;
	
	@Autowired
	MeanService meanService;
	
	@Override
	public VocabularyDTO getVocabulary(int num, long categoryId) {
		Pageable pageable = PageRequest.of(num,1);
		List<Vocabulary>vocabularies =  vocabularyRepository.getVocabulary(categoryId, pageable);
		
		VocabularyDTO vocabularyDTO = new VocabularyDTO();
		vocabularyDTO.setId(vocabularies.get(0).getId());
		vocabularyDTO.setName(vocabularies.get(0).getName());
		List<MeanDTO> meanDTOs = new ArrayList<MeanDTO>();
		for(Mean mean : vocabularies.get(0).getMeans()) {
			MeanDTO meanDTO = new MeanDTO();
			meanDTO.setId(mean.getId());
			meanDTO.setName(mean.getName());
			meanDTOs.add(meanDTO);
		}
		vocabularyDTO.setMeanDTOs(meanDTOs);
		return vocabularyDTO;
	}

	@Override
	public String[] createQuestion(long categoryId) {
		int num = getVocabularyCount(categoryId);
		int no = random.nextInt(num);
		VocabularyDTO vocabularyDTO = getVocabulary(no, categoryId);
		List<MeanDTO>meanDTOs = vocabularyDTO.getMeanDTOs();
		
		
		String correctAnswer="";
		try {
			correctAnswer = getRandomCorrectMean(meanDTOs);
		} catch (Exception e) {
			// TODO: handle exception
		}	
		List<String> means = meanService.getAllMean();
		String arr[] = new String[4];			
		int countArr= 0;
		String word1="";
		String word2="";
		String word3="";
		while(true) {
			int randomIndex = random.nextInt(means.size());
			int check = 0;
			for (int i = 0; i < vocabularyDTO.getMeanDTOs().size(); i++) {
				if(!means.get(randomIndex).equalsIgnoreCase(vocabularyDTO.getMeanDTOs().get(i).getName())) {
					check++;
				}
			}
			if(check == vocabularyDTO.getMeanDTOs().size()) {
				
				if(!means.get(randomIndex).equalsIgnoreCase(word1) && !means.get(randomIndex).equalsIgnoreCase(word1) && !means.get(randomIndex).equalsIgnoreCase(word1)) {				
					if(countArr == 0 ) {
						word1 = means.get(randomIndex);
					}
					if(countArr == 1 ) {
						word2 = means.get(randomIndex);
					}
					if(countArr == 2 ) {
						word3 = means.get(randomIndex);
					}
					
					countArr++;
				}														
			}					
			if(countArr == 3 ) {
				break;
			}					
		}
		arr[0] = word1;
		arr[1] = word2;
		arr[2] = word3;
		arr[3] = correctAnswer;
		
		
		
		for (int i = 0; i < arr.length; i++) {
			int index = random.nextInt(arr.length);
			String temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
		String []question = {vocabularyDTO.getName(),correctAnswer,arr[0],arr[1],arr[2],arr[3]};
		return question;
		
	}

	@Override
	public int getVocabularyCount(long categoryId) {
		
		int num = vocabularyRepository.countVocabulary(categoryId);
		return num;
	}

	@Override
	public String getRandomCorrectMean(List<MeanDTO> meanDTOs) {
		int randomIndex = random.nextInt(meanDTOs.size());
		
		return meanDTOs.get(randomIndex).getName();
		
	}

	

}
