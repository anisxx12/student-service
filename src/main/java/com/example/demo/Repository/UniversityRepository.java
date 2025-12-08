package com.example.demo.Repository;

import com.example.demo.Model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {

    University findByName(String name);
}