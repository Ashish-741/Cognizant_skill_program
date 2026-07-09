package week3.validation.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import week3.validation.dto.EmployeeRequestDTO;
import week3.validation.exception.DuplicateResourceException;
import week3.validation.exception.ResourceNotFoundException;

/**
 * REST Controller showcasing @Valid payload inspection and custom exception throws.
 */
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeValidationController {

    @PostMapping
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeRequestDTO requestDTO) {
        if ("admin@cognizant.com".equalsIgnoreCase(requestDTO.getEmail())) {
            throw new DuplicateResourceException("Employee with email 'admin@cognizant.com' already exists!");
        }

        return new ResponseEntity<>("Employee '" + requestDTO.getName() + "' created successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getEmployeeById(@PathVariable Long id) {
        if (id <= 0 || id > 1000) {
            throw new ResourceNotFoundException("Employee not found with ID: " + id);
        }
        return ResponseEntity.ok("Employee record found for ID: " + id);
    }
}
