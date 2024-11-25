package com.financial.payroll.controllers;

import com.financial.payroll.dto.EmployeeRequestDTO;
import com.financial.payroll.dto.EmployeeRequestUpdateDTO;
import com.financial.payroll.dto.EmployeeResponseDTO;
import com.financial.payroll.dto.EmployeeResponseDetailDTO;
import com.financial.payroll.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/save-employee")
    public EmployeeRequestDTO saveEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {

        return employeeService.saveEmployee(employeeRequestDTO);
    }

    @GetMapping(value = "/get-employees")
    public List<EmployeeResponseDTO> getEmployees() {

        return employeeService.getEmployees();
    }

    @GetMapping(value="/get-employee-detail/{id}")
    public EmployeeResponseDetailDTO getEmployeeDetail(@PathVariable("id") long id){

        return employeeService.getEmployeeDetail(id);
    }

    @PutMapping(value="/update-employee")
    public EmployeeRequestUpdateDTO updateEmployee(@RequestBody EmployeeRequestUpdateDTO employeeRequestUpdateDTO){

        return  employeeService.updateEmployee(employeeRequestUpdateDTO);
    }
}
