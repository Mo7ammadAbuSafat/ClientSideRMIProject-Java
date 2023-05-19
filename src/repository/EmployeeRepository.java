package repository;

import model.Employee;

import java.rmi.Remote;
import java.util.List;

public interface EmployeeRepository extends Remote {

    Employee findById(Long id) throws Exception;

    List<Employee> findAll() throws Exception;

    Long create(Employee employee) throws Exception;

    boolean update(Employee employee) throws Exception;

    boolean deleteById(Long id) throws Exception;

    void deleteAll() throws Exception;

}
