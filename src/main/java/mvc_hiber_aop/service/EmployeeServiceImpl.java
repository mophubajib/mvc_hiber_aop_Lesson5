package mvc_hiber_aop.service;

import mvc_hiber_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@EnableTransactionManagement
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void deleteEmployee(Integer id) {

        if (id !=null){
            Session session = null;
            session = sessionFactory.openSession();
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            session.delete(employee);
            session.getTransaction().commit();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {

        Employee oldEmployee;
        Session session = null;
        session = sessionFactory.openSession();
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        oldEmployee = session.get(Employee.class, employee.getId());

        oldEmployee.setDepartment(employee.getDepartment());
        oldEmployee.setName(employee.getName());
        oldEmployee.setSurname(employee.getSurname());
        oldEmployee.setSalary(employee.getSalary());

        session.save(oldEmployee);
        session.getTransaction().commit();
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee;
        Session session;
        session = sessionFactory.openSession();
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        employee = session.get(Employee.class, id);
        session.getTransaction().commit();

        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {

        Session session = null;
        session = sessionFactory.openSession();
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
    }

    @Override
    public List<Employee> getEmployees() {

        Session session = null;
        session = sessionFactory.openSession();
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Employee> test = session.createQuery("from Employee", Employee.class)
                .getResultList();
        session.getTransaction().commit();

        return test;
    }


    @PostConstruct
    public void createEmployees() {

        Employee alex = new Employee("Aleksey", "Moiseychev", "IT", 2000);
        Employee alinka = new Employee("Alinka","Salminskaya", "Post", 500);
        Employee murra = new Employee("Murra", "Moiseycheva", "Home", 0);
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(alex);
            session.save(alinka);
            session.save(murra);
            session.getTransaction().commit();
        } finally {
            session.close();
        }

    }
}
