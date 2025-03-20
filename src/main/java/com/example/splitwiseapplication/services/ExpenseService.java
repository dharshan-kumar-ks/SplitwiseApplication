package com.example.splitwiseapplication.services;

import com.example.splitwiseapplication.Dtos.CreateExpenseDto;
import com.example.splitwiseapplication.models.*;
import com.example.splitwiseapplication.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ExpenseService {
    private final UserExpenseRepository userExpenseRepository;
    public UserRepository userRepository;
    public GroupRepository groupRepository;
    public ExpenseRepository expenseRepository;
    
    public ExpenseService(UserRepository userRepository, GroupRepository groupRepository, ExpenseRepository expenseRepository, UserExpenseRepository userExpenseRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.userExpenseRepository = userExpenseRepository;
    }

    // to avoid scenarios like expenses are created but users are not found
    // all operations in the function will be considered as a single transaction.
    @Transactional
    public Expense createExpense(CreateExpenseDto createExpenseDto) {
        // paidByUsers:
        // Get all User ids who had paid for the expense
        Set<Long> paidByUserIds = createExpenseDto.getPaidBy().keySet();
        // Get the corresponding User objects from their USer ids -> who had paid for the expense
        List<User> paidByUsers = userRepository.findAllById(paidByUserIds);

        // if no users are present for the given userId -> throw an error
        if(paidByUserIds.size() != paidByUsers.size()) {
            throw new IllegalArgumentException("Users are invalid");
        }

        // owedByUsers:
        // Get all User ids who had paid for the expense
        Set<Long> owedByUserIds = createExpenseDto.getPaidBy().keySet();
        // Get the corresponding User objects from their USer ids -> who had paid for the expense
        List<User> owedByUsers = userRepository.findAllById(owedByUserIds);

        // if no users are present for the given userId -> throw an error
        if(owedByUserIds.size() != owedByUsers.size()) {
            throw new IllegalArgumentException("Users are invalid");
        }

        // Get the group to which the expense is attached to
        Optional<Group> groupOptional = groupRepository.findById(createExpenseDto.getGroupId());

        // Create and save an expense object (based on the attributes extracted till now)
        Expense expense = Expense.builder()
                .name(createExpenseDto.getName())
                .group(groupOptional.get())
                .amount(createExpenseDto.getAmount())
                .build();
        Expense savedExpense = expenseRepository.save(expense);

        // Find out who all paid
        List<UserExpense> paidByUserExpenses = new ArrayList<>();
        for(Map.Entry<Long, Integer> entry : createExpenseDto.getPaidBy().entrySet()) {
            Long userId = entry.getKey();
            int amount = entry.getValue();

            User user = userRepository.findById(userId).orElseThrow();
            UserExpense userExpense = new UserExpense(savedExpense, user, amount);
            paidByUserExpenses.add(userExpense);
        }
        userExpenseRepository.saveAll(paidByUserExpenses);

        // Find out who all owe
        List<UserExpense> owedByUserExpenses = new ArrayList<>();
        for(Map.Entry<Long, Integer> entry : createExpenseDto.getPaidBy().entrySet()) {
            Long userId = entry.getKey();
            int amount = entry.getValue();

            User user = userRepository.findById(userId).orElseThrow();
            UserExpense userExpense = new UserExpense(savedExpense, user, -amount);
            owedByUserExpenses.add(userExpense);
        }
        userExpenseRepository.saveAll(owedByUserExpenses);

        return savedExpense;
    }
}
