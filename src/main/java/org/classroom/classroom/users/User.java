package org.classroom.classroom.users;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email; 
    private String role; 
}
