package net.dmsegypt.Spring.Exercise.controller;

import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.dmsegypt.Spring.Exercise.entity.Department;
import net.dmsegypt.Spring.Exercise.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @RequestMapping("/")
    public String homeRedirect() {
        return "redirect:/department";
    }
    @GetMapping("/department")
    public String department(Model model) {
            model.addAttribute("department", new Department());
            populateModelWithDepartments(model);
            return "department";
    }
    @PostMapping("/department")
    public String saveDepartment(@Valid @ModelAttribute("department") Department newDepartment, BindingResult bindingResult,RedirectAttributes redirectAttributes, Model model) {
        if(departmentService.isDuplicateDepartment(newDepartment)) {
            bindingResult.rejectValue("code", "duplicate.department",
                    String.format("Department with code %s already exists.", newDepartment.getCode()));

        }
        if(bindingResult.hasErrors()) {
            populateModelWithDepartments(model);
            return "department";
        }
        departmentService.saveDepartment(newDepartment);
        redirectAttributes.addFlashAttribute("successMessage", String.format("Department With code  %s added successfully.", newDepartment.getCode()));
        return "redirect:/department";
    }


    private void populateModelWithDepartments(Model model) {
        model.addAttribute("departmentList", departmentService.getAllDepartments());
    }
}
