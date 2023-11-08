package com.example.springnews.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="departmentname")
    private String department;


    public Story(int id, String name, String description, String department) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.department=department;

    }
    public Story(){}

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story task = (Story) o;
        return id==task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
