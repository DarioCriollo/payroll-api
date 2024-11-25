package com.financial.payroll.services;

import com.financial.payroll.dto.EmployeeRequestDTO;
import com.financial.payroll.dto.EmployeeRequestUpdateDTO;
import com.financial.payroll.dto.EmployeeResponseDTO;
import com.financial.payroll.dto.EmployeeResponseDetailDTO;
import com.financial.payroll.models.Employee;
import com.financial.payroll.repository.EmployeeRepository;
import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper){
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeRequestDTO saveEmployee( EmployeeRequestDTO employeeRequestDTO)  {
        try{
            Employee employee = modelMapper.map(employeeRequestDTO, Employee.class);
            employeeRepository.save(employee);

            return employeeRequestDTO;

        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    public List<EmployeeResponseDTO> getEmployees(){

        List<EmployeeResponseDTO> employeeResponseList = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAll();

        employees.forEach(employee -> {
            EmployeeResponseDTO responseDTO = new EmployeeResponseDTO(
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getMiddleName(),
                    employee.getLastName(),
                    employee.getPositionTitle(),
                    employee.isStatus(),
                    employee.getLocationCity(),
                    employee.getAddress(),
                    employee.getDateBirth(),
                    employee.getTelephone(),
                    employee.getHireDate(),
                    employee.getEmail(),
                    employee.getSalary(),
                    employee.getTimePosition()

            );
            employeeResponseList.add(responseDTO);
        });

        return  employeeResponseList;

    }

    public EmployeeResponseDetailDTO getEmployeeDetail(Long id){

        try{
            Optional<Employee> employee = employeeRepository.findById(id);

            return EmployeeResponseDetailDTO.builder()
                    .firstName(employee.get().getFirstName())
                    .middleName(employee.get().getMiddleName())
                    .lastName(employee.get().getLastName())
                    .locationCity(employee.get().getLocationCity())
                    .address(employee.get().getAddress())
                    .dateBirth(employee.get().getDateBirth())
                    .telephone(employee.get().getTelephone())
                    .positionTitle(employee.get().getPositionTitle())
                    .hireDate(employee.get().getHireDate())
                    .email(employee.get().getEmail())
                    .salary(employee.get().getSalary())
                    .timePosition(employee.get().getTimePosition())
                    .build();
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Employee not found");
        }

    }

    public EmployeeRequestUpdateDTO updateEmployee(EmployeeRequestUpdateDTO employeeRequestUpdateDTO){

        Employee employee = modelMapper.map(employeeRequestUpdateDTO, Employee.class);
        employeeRepository.save(employee);
        return employeeRequestUpdateDTO;
    }
}
