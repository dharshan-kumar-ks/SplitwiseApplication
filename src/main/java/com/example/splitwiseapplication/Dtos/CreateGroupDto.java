package com.example.splitwiseapplication.Dtos;

import com.example.splitwiseapplication.models.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateGroupDto {
    private String name;
    private List<Long> userIds;
}
