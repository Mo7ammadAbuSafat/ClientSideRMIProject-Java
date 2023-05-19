package controller;

import model.Employee;
import repository.EmployeeRepository;

import java.rmi.Naming;
import java.util.List;

public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController() throws Exception{
        this.repository = (EmployeeRepository) Naming.lookup("rmi://192.168.2.2:5000/repository");
    }

    public List<Employee> findAll() throws Exception {
        return repository.findAll();
    }

    public Employee findById(Long id) throws Exception {
        return repository.findById(id);
    }

    public Long create(Employee employee) throws Exception {
        return repository.create(employee);
    }

    public boolean deleteById(Long id) throws Exception {
        return repository.deleteById(id);
    }

    public boolean update(Employee employee) throws Exception {
        return repository.update(employee);
    }

}

