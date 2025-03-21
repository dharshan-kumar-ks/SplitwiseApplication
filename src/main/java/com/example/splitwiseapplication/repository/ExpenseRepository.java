package com.example.splitwiseapplication.repository;

import com.example.splitwiseapplication.models.Expense;
import com.example.splitwiseapplication.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
