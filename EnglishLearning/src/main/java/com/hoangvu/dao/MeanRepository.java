package com.hoangvu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoangvu.entity.Mean;

@Repository
public interface MeanRepository extends JpaRepository<Mean, Long>{

}
