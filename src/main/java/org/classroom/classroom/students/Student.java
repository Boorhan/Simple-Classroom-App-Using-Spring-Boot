package org.classroom.classroom.students;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

import org.classroom.classroom.courses.Course;
import org.classroom.classroom.users.User;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Student extends User {
    @ManyToMany(mappedBy = "students")
    private List<Course> enrolledCourses;
}
