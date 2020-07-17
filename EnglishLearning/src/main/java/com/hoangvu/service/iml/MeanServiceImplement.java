package com.hoangvu.service.iml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoangvu.dao.MeanRepository;
import com.hoangvu.entity.Mean;
import com.hoangvu.service.MeanService;
@Service
public class MeanServiceImplement implements MeanService{
	
	@Autowired
	MeanRepository meanRepository;
	
	@Override
	public List<String> getAllMean() {
		List<Mean>means = meanRepository.findAll();
		List<String>meanss = new ArrayList<String>();
		for(Mean mean : means) {
			meanss.add(mean.getName());
		}
		
		return meanss;
	}

}
