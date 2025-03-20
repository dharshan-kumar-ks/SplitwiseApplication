package com.example.splitwiseapplication.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "expenses")
public class Expense extends BaseModel {
    String name;

    // Multiple expense can be part of 1 Group
    @ManyToOne
    @JoinColumn(name = "group_id")
    Group group;

    int amount;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "expense")
    List<UserExpense> paidBy;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "expense")
    List<UserExpense> owedBy;
}



