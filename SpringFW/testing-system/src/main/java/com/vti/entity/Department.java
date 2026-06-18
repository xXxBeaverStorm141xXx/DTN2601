package com.vti.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Data
public class Department {
    @Id // khoa chinh
    @Column(name = "DepartmentID")// dang tro toi column DepartmentID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
    private Integer id;

    @Column(name = "DepartmentName", nullable = false, unique = true, length = 50)
    private String name;

//    @OneToMany(mappedBy = "department")
//    @ToString.Exclude
//    private List<Account> accounts;
}
