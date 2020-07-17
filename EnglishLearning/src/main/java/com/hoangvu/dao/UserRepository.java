package com.hoangvu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hoangvu.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	
	@Query(value="select * from user where username = ?1",nativeQuery = true)
	User loadUserByUserName(@Param(value = "username")String username);
}
