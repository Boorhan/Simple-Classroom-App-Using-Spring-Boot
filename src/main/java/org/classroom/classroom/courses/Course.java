package org.classroom.classroom.courses;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.classroom.classroom.teachers.Teacher;
import org.classroom.classroom.students.Student;
import java.util.List; 
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String description;

    @ManyToOne
    private Teacher teacher;

    @ManyToMany
    @JoinTable(
        name = "enrollment",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;
}
