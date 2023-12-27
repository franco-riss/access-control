package com.s2r.accesscontrol.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="users")
public class UserModel {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(name="last_name", nullable = false)
    private String lastName;
    @Column(name="first_name", nullable = false)
    private String firstName;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="sector", nullable = false)
    private String sector;
    @Column(name="phone", nullable = false)
    private String phone;
    @Column(name="email", nullable = false)
    private String email;
    @ElementCollection
    @CollectionTable(name = "user_tags", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "tag", nullable = false)
    private List<String> tags;
}