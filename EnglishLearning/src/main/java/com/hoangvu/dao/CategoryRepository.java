package com.hoangvu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hoangvu.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	@Query(value = "select * from category where name = ?1",nativeQuery = true)
	public Category loadCategoryByName(@Param(value = "name")String name);
}
