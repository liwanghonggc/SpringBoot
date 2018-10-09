package com.lwh.springboot.chp6.mapper;

/**
 * @author lwh
 * @date 2018-10-09
 * @desp
 */

import com.lwh.springboot.chp6.bean.Employee;

/**
 *  @Mapper或是@MapperScan将接口扫描装配到容器中
 */
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    void insertEmp(Employee employee);
}
