package com.gzh.springbootweb.controller;

import com.gzh.springbootweb.dao.DepartmentDao;
import com.gzh.springbootweb.dao.EmployeeDao;
import com.gzh.springbootweb.entity.Department;
import com.gzh.springbootweb.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author GZH
 * @date 2021-12-04
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getEmployees();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdatePage(@PathVariable Integer id, Model model) {
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/update";
    }

    @PostMapping("/emp/{id}")
    public String updateEmp(@PathVariable Integer id, Employee employee) {
        System.out.println("修改id：" + id + "，" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/delEmp/{id}")
    public String deleteEmp(@PathVariable Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
