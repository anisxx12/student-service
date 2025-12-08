package com.example.demo.Service;

import com.example.demo.Model.Student;
import com.example.demo.Model.University;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UniversityRepository universityRepository;

    // Save or update student with linked university
    public Student saveStudent(Student student) {
        // Fetch the university by ID from the student object
        if (student.getUniversity() != null && student.getUniversity().getId() != 0) {
            Optional<University> uniOpt = universityRepository.findById(student.getUniversity().getId());
            if (uniOpt.isPresent()) {
                student.setUniversity(uniOpt.get());
            } else {
                throw new RuntimeException("University not found with id: " + student.getUniversity().getId());
            }
        } else {
            throw new RuntimeException("University ID is required");
        }

        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public List<Student> searchByFirstName(String firstName) {
        return studentRepository.findByFirstNameContainingIgnoreCase(firstName);
    }

    public List<Student> searchByLastName(String lastName) {
        return studentRepository.findByLastNameContainingIgnoreCase(lastName);
    }

    public List<Student> searchByEmail(String email) {
        return studentRepository.findByEmailContainingIgnoreCase(email);
    }
}
