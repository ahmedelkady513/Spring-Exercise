package net.dmsegypt.Spring.Exercise.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.dmsegypt.Spring.Exercise.entity.Employee;
import net.dmsegypt.Spring.Exercise.service.DepartmentService;
import net.dmsegypt.Spring.Exercise.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    private final DepartmentService departmentService;
    @GetMapping("/employee")
    public String employee(Model model) {
        model.addAttribute("employee" , new Employee());
        model.addAttribute("departmentList", departmentService.getAllDepartments());
        populateModelWithEmployeesAndDepartments(model);
        return "employee";
    }

    @PostMapping("/employee")
    public String employee(@Valid @ModelAttribute("employee") Employee newEmployee, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if(employeeService.isDuplicateEmployee(newEmployee)) {
            bindingResult.rejectValue("code", "duplicate.employee",
                    String.format("Employee with code %s already exists.", newEmployee.getCode()));

        }
        if(bindingResult.hasErrors()) {
            populateModelWithEmployeesAndDepartments(model);
            return "employee";
        }
        employeeService.saveEmployee(newEmployee);
        redirectAttributes.addFlashAttribute("successMessage", String.format("Employee With code  %s added successfully.", newEmployee.getCode()));
        return "redirect:/employee";
    }

    @GetMapping("/employee/search")
    public String employeeSearch(@RequestParam("employeeName") String employeeName, Model model) {
        model.addAttribute("employeeName", employeeName);
        model.addAttribute("employeeResult", employeeService.searchEmployee(employeeName));
        return "employee-search";
    }
    private void populateModelWithEmployeesAndDepartments(Model model) {
        model.addAttribute("departmentList", departmentService.getAllDepartments());
        model.addAttribute("employeeList", employeeService.getAllEmployees());
    }
}
