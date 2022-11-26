package com.example.projektzaliczeniehamzaensar.Controller;



import com.example.projektzaliczeniehamzaensar.Model.Employee;
import com.example.projektzaliczeniehamzaensar.Repository.EmployeeRepository;
import com.example.projektzaliczeniehamzaensar.Service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {




    private final EmployeeService employeeService;

    public EmployeeController( EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);

    }
    @GetMapping("/get")
    public List<Employee> getAllEmployee(){

        return employeeService.getAllEmployee();
    }



    @DeleteMapping("/delete/{id}")
    public void deleteEmployee (@PathVariable("id") long id){
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("employee/get/{id}")
    public Employee getEmployeeById(@PathVariable("id") long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employee/update/{id}")
    public Employee updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        return employeeService.updateById(id,employee);
    }
}


