package com.vti.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @Column(name = "AccountID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Email", unique = true, length = 50)
    private String email;

    @Column(name = "Username", nullable = false, unique = true, length = 50)
    private String userName;

    @Column(name = "Fullname", nullable = false)
    private String fullName;

    @Column(name = "DepartmentID")
    private Integer departmentId;

    @Column(name = "PositionID")
    private Integer positionId;

    @Column(name = "CreateDate")
    private LocalDate createDate;
}
