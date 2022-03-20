package com.gzh.springbootweb.dao;

import com.gzh.springbootweb.entity.Department;
import com.gzh.springbootweb.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GZH
 * @date 2021-12-03
 */
@Repository
public class EmployeeDao {

    //模拟数据
    private static Map<Integer, Employee> employeeMap = new HashMap<>();

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employeeMap.put(1001, new Employee(1001, "AA1","121@qq.com", 1, new Department(101, "教学部")));
        employeeMap.put(1002, new Employee(1002, "AA2","122@qq.com", 0, new Department(102, "市场部")));
        employeeMap.put(1003, new Employee(1003, "AA3","123@qq.com", 1, new Department(103, "教研部")));
        employeeMap.put(1004, new Employee(1004, "AA4","124@qq.com", 0, new Department(104, "运营部")));
        employeeMap.put(1005, new Employee(1005, "AA5","125@qq.com", 1, new Department(105, "后勤部")));
    }

    private static Integer initId = 1006;

    /**
     * 增加、修改一个员工
     */
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(), employee);
    }

    /**
     * 查询所有员工信息
     */
    public Collection<Employee> getEmployees() {
        return employeeMap.values();
    }

    /**
     * 通过id查询员工
     */
    public Employee getEmployeeById(Integer id) {
        return employeeMap.get(id);
    }

    /**
     * 通过id删除员工
     */
    public void delete(Integer id) {
        employeeMap.remove(id);
    }

}
