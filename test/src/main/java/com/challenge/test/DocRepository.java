package com.challenge.test;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DocRepository extends JpaRepository<Doc, Integer> {

	@Query("SELECT dr FROM DocRead dr WHERE (dr.readTime) = ?1")
	public List<DocRead> find(@Param("lastName") Date date);

}
