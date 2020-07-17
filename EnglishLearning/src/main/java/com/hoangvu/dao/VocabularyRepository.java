package com.hoangvu.dao;



import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hoangvu.entity.Vocabulary;

@Repository
public interface VocabularyRepository extends JpaRepository<Vocabulary, Long>{
	
	@Query(value = "select * from vocabulary where category_id = ?1",nativeQuery = true)
	public List<Vocabulary> getVocabulary(long categoryId,Pageable pageable);
	
	@Query(value="select count(id) from vocabulary where category_id = ?1",nativeQuery = true)
	public int countVocabulary(@Param(value="category_id")long categoryId);
}
