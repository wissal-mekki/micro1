package com.project.micro1.services;

import com.project.micro1.entities.Employee;
import com.project.micro1.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    //private final Logger log = LoggerFactory.getLogger(EmployeeController.class):
    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> CreateEmployee(@Valid @RequestBody Employee employee) throws URISyntaxException {
        if (employee.getID() != null) {

            System.out.println("ID is already exists"); // I must verify  the Execption
        }

        Employee result = this.employeeRepository.save(employee);
        return ResponseEntity.created(new URI("/api/employees/" + result.getID())).header("Employee " + result.getID()).body(result);
    }
    /*

     */

    @GetMapping("/employees")
    public List<Employee> GetAllEmployees() {

        return employeeRepository.findAll();
    }

}







