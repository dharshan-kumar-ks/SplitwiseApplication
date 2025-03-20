package com.example.splitwiseapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "splitwise_groups")
public class Group extends BaseModel {
    private String name;

    @ManyToMany
    List<User> users;
}
