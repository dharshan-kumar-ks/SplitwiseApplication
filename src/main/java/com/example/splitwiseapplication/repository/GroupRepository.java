package com.example.splitwiseapplication.repository;

import com.example.splitwiseapplication.models.Expense;
import com.example.splitwiseapplication.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    // custom data retrival using JPL
    @Query("select e from Expense e where e.group = ?1") // ?1 means first paramater 'group'
    List<Expense> findAllByGroup(Group group);
}
