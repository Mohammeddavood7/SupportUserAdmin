package com.support.useradmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/register")
    public User registerAdmin(@RequestBody @Validated User admin) {
        admin.setRole("ADMIN");
        return userService.registerUser(admin);
    }

    @PostMapping("/login")
    public User loginAdmin(@RequestParam String username, @RequestParam String password) {
        return userService.loginUser(username, password);
    }

    @GetMapping("/assignments")
    public List<Assignment> getAssignments(@RequestParam String admin) {
        return assignmentService.getAssignmentsByAdmin(admin);
    }

    @PostMapping("/assignments/{id}/accept")
    public Assignment acceptAssignment(@PathVariable Long id) {
        return assignmentService.updateAssignmentStatus(id, "Accepted");
    }

    @PostMapping("/assignments/{id}/reject")
    public Assignment rejectAssignment(@PathVariable Long id) {
        return assignmentService.updateAssignmentStatus(id, "Rejected");
    }
}
