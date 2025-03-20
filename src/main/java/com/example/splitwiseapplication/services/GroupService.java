package com.example.splitwiseapplication.services;

import com.example.splitwiseapplication.models.*;
import com.example.splitwiseapplication.repository.GroupRepository;
import com.example.splitwiseapplication.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public GroupService(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    public Group createGroup(String name, List<Long> userIds) {
        // Retrieve the User objects using the userIds from input
        List<User> users = userRepository.findAllById(userIds);

        // if no users are present for the given userId -> throw an error
        if(userIds.size() != users.size()) {
            throw new IllegalArgumentException("Users are invalid");
        }

        Group group = new Group(name, users);
        return groupRepository.save(group);
    }


}
