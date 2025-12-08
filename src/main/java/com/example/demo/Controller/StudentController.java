    package com.example.demo.Controller;

    import com.example.demo.Model.Student;
    import com.example.demo.Service.StudentService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/student")
    public class StudentController {

        @Autowired
        private StudentService studentService;

        // Add new student
        @PostMapping("/add")
        public Student addStudent(@RequestBody Student student) {
            return studentService.saveStudent(student);
        }

        // Update existing student
        @PutMapping("/update/{id}")
        public Student updateStudent(@PathVariable Integer id, @RequestBody Student student) {
            student.setId(id);
            return studentService.saveStudent(student);
        }

        // Delete student
        @DeleteMapping("/delete/{id}")
        public String deleteStudent(@PathVariable Integer id) {
            studentService.deleteStudent(id);
            return "Student deleted with ID: " + id;
        }

        // Get all students
        @GetMapping("/all")
        public List<Student> getAllStudents() {
            return studentService.getAllStudents();
        }

        // Get student by ID
        @GetMapping("/{id}")
        public Optional<Student> getStudentById(@PathVariable Integer id) {
            return studentService.getStudentById(id);
        }

        // Search by first name
        @GetMapping("/search/firstName")
        public List<Student> searchByFirstName(@RequestParam String firstName) {
            return studentService.searchByFirstName(firstName);
        }

        // Search by last name
        @GetMapping("/search/lastName")
        public List<Student> searchByLastName(@RequestParam String lastName) {
            return studentService.searchByLastName(lastName);
        }

        // Search by email
        @GetMapping("/search/email")
        public List<Student> searchByEmail(@RequestParam String email) {
            return studentService.searchByEmail(email);
        }
    }
