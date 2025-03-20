package com.example.splitwiseapplication.repository;

import com.example.splitwiseapplication.models.Expense;
import com.example.splitwiseapplication.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExpenseRepository extends JpaRepository<UserExpense, Long>  {

}
