package com.lwh.springboot.chp4.controller;

import com.lwh.springboot.chp4.dao.DepartmentDao;
import com.lwh.springboot.chp4.dao.EmployeeDao;
import com.lwh.springboot.chp4.entities.Department;
import com.lwh.springboot.chp4.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 查询所有员工,返回员工列表
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "/emp/list";
    }

    /**
     * 来到员工添加页面
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        /** 查出所有部门 **/
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }


    /**
     * 员工添加
     * @param employee SpringMVC自动将请求参数和对象属性一一绑定
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        employeeDao.save(employee);
        /** 来到员工列表页面 redirect表示重定向到一个地址,/表示当前项目路径 **/
        return "redirect:/emps";
    }

    /**
     * 来到员工修改页面,查出当前员工,在页面回显
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id")Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        /** 查出所有部门 **/
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //修改和添加二合一
        return "emp/add";
    }

    /**
     * 员工修改,需要提交员工id
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 员工删除
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
