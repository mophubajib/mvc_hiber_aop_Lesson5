package mvc_hiber_aop.service;

import mvc_hiber_aop.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void updateEmployee(Employee employee);

    void deleteEmployee(Integer id);
}
