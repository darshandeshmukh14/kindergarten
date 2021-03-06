package com.kindergarten.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kindergarten.model.Academy;

@Repository
public interface AcademyRepo extends JpaRepository<Academy, Integer> {
	
	Academy findByAcademyName(String academyName);

	Academy findByAcademyId(int academyId);

	Boolean existsByAcademyName(String academyName);
}
