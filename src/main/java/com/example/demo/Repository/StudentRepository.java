package com.example.demo.Repository;

import com.example.demo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Search by firstName or lastName
    List<Student> findByFirstNameContainingIgnoreCase(String firstName);
    List<Student> findByLastNameContainingIgnoreCase(String lastName);

    // Search by email
    List<Student> findByEmailContainingIgnoreCase(String email);

    // Search by university name
    @Query("SELECT s FROM Student s WHERE s.university.name = :univName")
    List<Student> findByUniversityName(@Param("univName") String univName);
}