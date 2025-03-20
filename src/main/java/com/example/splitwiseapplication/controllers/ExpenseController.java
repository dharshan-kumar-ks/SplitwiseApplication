package com.example.splitwiseapplication.controllers;

import com.example.splitwiseapplication.Dtos.CreateExpenseDto;
import com.example.splitwiseapplication.models.Expense;
import com.example.splitwiseapplication.services.ExpenseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("expenses")
public class ExpenseController {
    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public Expense createExpense(@RequestBody CreateExpenseDto createExpenseDto) {
        return expenseService.createExpense(createExpenseDto);
    }
}
