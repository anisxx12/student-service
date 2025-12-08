package com.example.demo.Controller;

import com.example.demo.Model.University;
import com.example.demo.Repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    private UniversityRepository universityRepository;

    @PostMapping("/add")
    public University addUniversity(@RequestBody University university) {
        return universityRepository.save(university);
    }

    @GetMapping("/all")
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }
}
