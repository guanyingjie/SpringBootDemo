package com.springboot.restful.Domain.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String schoolName;
    private String description;

    public School(String schoolName, String description) {
        this.schoolName = schoolName;
        this.description = description;
    }
}
