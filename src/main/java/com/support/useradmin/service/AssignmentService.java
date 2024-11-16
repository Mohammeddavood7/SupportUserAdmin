package com.support.useradmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.useradmin.entity.Assignment;
import com.support.useradmin.repository.AssignmentRepository;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;

    public Assignment uploadAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAssignmentsByAdmin(String admin) {
        return assignmentRepository.findByAdmin(admin);
    }

    public Assignment updateAssignmentStatus(Long id, String status) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found!"));
        assignment.setStatus(status);
        return assignmentRepository.save(assignment);
    }
}
