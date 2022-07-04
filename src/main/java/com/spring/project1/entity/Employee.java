package com.spring.project1.entity;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "empoyees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "mobile", nullable = false)
    private String msdn;
    @Column(name = "email", nullable = false)
    private String email;


}
