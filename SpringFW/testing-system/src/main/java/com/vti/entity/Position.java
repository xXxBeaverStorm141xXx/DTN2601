package com.vti.entity;

import com.vti.enums.ArticlePositionNameConverter;
import com.vti.enums.PositionName;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "position")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    @Id // khoa chinh
    @Column(name = "PositionID")// dang tro toi column DepartmentID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
    private Integer id;


    @Enumerated(EnumType.STRING)// STRING: java show nhu nao thi DB luu nhu vay, ORDINAL: luu thanh so theo vi tri enums
    @Column(name = "PositionName", nullable = false)
    private PositionName name;

//    @OneToMany(mappedBy = "position")
//    @ToString.Exclude
//    private List<Account> accounts;
}
