package com.gzh.springbootweb.dao;

import com.gzh.springbootweb.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GZH
 * @date 2021-12-03
 */
@Repository
public class DepartmentDao {

    //模拟数据
    private static Map<Integer, Department> departmentMap = new HashMap<>();

    static {
        departmentMap.put(101, new Department(101, "教学部"));
        departmentMap.put(102, new Department(102, "市场部"));
        departmentMap.put(103, new Department(103, "教研部"));
        departmentMap.put(104, new Department(104, "运营部"));
        departmentMap.put(105, new Department(105, "后勤部"));
    }

    /**
     * 查询所有部门信息
     */
    public Collection<Department> getDepartments() {
        return departmentMap.values();
    }

    /**
     * 通过id查询部门
     */
    public Department getDepartmentById(Integer id) {
        return departmentMap.get(id);
    }

}
