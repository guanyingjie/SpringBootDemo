package com.springboot.restful.Domain.Entity;

import lombok.Data;

@Data
public class Book {
    private int id;
    private String name;
    private String description;

    public Book(int id, String name, String description) {
    }
}
