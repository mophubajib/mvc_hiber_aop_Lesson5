package mvc_hiber_aop.controller;

import mvc_hiber_aop.entity.Employee;
import mvc_hiber_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        employeeService.deleteEmployee(id);
        return "redirect:/employee/list";
    }

    @RequestMapping("/update")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("createEmployee", employee);
        return "employee/create";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("createEmployee") Employee employee) {

        if (employee.getId() != 0) {
            employeeService.updateEmployee(employee);
        } else {
            employeeService.saveEmployee(employee);
        }
        return "redirect:/employee/list";
    }

    @GetMapping("/create")
    public String createEmployee(Model model) {
        model.addAttribute("createEmployee", new Employee());
        return "employee/create";
    }

    @GetMapping("/list")
    public String getEmployees(Model model) {

        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("modelEmployees", employees);

        return "employee/list";
    }





    /*    @GetMapping("/employee")
    public String getEmployee() {
        return "employee/get";
    }*/
}
