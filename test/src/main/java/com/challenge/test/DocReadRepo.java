package com.challenge.test;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DocReadRepo extends JpaRepository<DocRead, Integer> {

	@Query("FROM DocRead  WHERE readTime between ?1 AND ?2 ")
	public List<DocRead> find(@Param("fromDate") Date fromDate,@Param("toDate") Date toDate);

}
