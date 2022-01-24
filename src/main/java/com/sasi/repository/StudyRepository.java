package com.sasi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sasi.entity.Study;
@Repository
public interface StudyRepository extends JpaRepository<Study, Integer> {

}
