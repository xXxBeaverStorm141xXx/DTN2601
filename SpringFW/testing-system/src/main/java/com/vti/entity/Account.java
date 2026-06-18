package com.vti.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

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

    @Column
    private String password;

    @ManyToOne
    @JoinColumn(name = "DepartmentID")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "PositionID")
    private Position position;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreateDate", insertable = false, updatable = false)
    private Date createDate;
}
