package org.classroom.classroom.teachers;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import java.util.List; 
import org.classroom.classroom.courses.Course;
import org.classroom.classroom.users.User;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Teacher extends User {
    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;
}


