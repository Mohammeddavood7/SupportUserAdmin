package com.support.useradmin.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.support.useradmin.entity.Assignment;
import com.support.useradmin.entity.User;
import com.support.useradmin.service.AssignmentService;
import com.support.useradmin.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/register")
    public User registerUser(@RequestBody @Validated User user) {
        user.setRole("USER");
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestParam String username, @RequestParam String password) {
        return userService.loginUser(username, password);
    }

    @PostMapping("/upload")
    public Assignment uploadAssignment(@RequestBody @Validated Assignment assignment) {
        return assignmentService.uploadAssignment(assignment);
    }

    @GetMapping("/admins")
    public List<User> getAdmins() {
        return userService.getAllUsers().stream()
                .filter(user -> "ADMIN".equals(user.getRole()))
                .collect(Collectors.toList());
    }
}
