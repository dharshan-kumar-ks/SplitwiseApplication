package com.example.splitwiseapplication.Dtos;

import lombok.Data;

import java.util.Map;

@Data
public class CreateExpenseDto {
    String name;
    int amount;
    Long groupId;
    // Just List of Ids are enough instead of List of UserExpense objects from the client
    Map<Long, Integer> paidBy;
    Map<Long, Integer> owedBy;
}
