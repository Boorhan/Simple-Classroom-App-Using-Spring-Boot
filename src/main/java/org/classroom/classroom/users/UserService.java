package org.classroom.classroom.users;

import org.classroom.classroom.students.Student;
import org.classroom.classroom.students.StudentRepository;
import org.classroom.classroom.teachers.Teacher;
import org.classroom.classroom.teachers.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;


    public User saveUser(User user) {
        // Save the user to the User table first
        User savedUser = userRepository.save(user);

        // Based on role, add to Teacher or Student table
        if ("teacher".equalsIgnoreCase(user.getRole())) {
            Teacher teacher = new Teacher();
            teacher.setId(savedUser.getId()); // ID from User
            teacher.setUsername(savedUser.getUsername());
            teacher.setPassword(savedUser.getPassword());
            teacher.setEmail(savedUser.getEmail());
            teacherRepository.save(teacher);
        } else if ("student".equalsIgnoreCase(user.getRole())) {
            Student student = new Student();
            student.setId(savedUser.getId()); // ID from User
            student.setUsername(savedUser.getUsername());
            student.setPassword(savedUser.getPassword());
            student.setEmail(savedUser.getEmail());
            studentRepository.save(student);
        }

        return savedUser;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    // You can add more business methods as needed
}