package com.hutech.javas3d3.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
