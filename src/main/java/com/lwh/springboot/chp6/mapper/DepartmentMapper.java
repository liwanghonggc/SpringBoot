package com.lwh.springboot.chp6.mapper;

import com.lwh.springboot.chp6.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @author lwh
 * @date 2018-10-09
 * @desp
 */

/**
 * 指定这是一个操作数据库的Mapper
 * Mybatis注解版
 */
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    Department getDeptById(Integer id);

    @Delete("delete from department where id = #{id}")
    int delteDeptById(Integer id);

    /**
     * 返回自增主键
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    int insertDept(Department department);

    @Update("update department set departmentName = #{departmentName} where id = #{id}")
    int updateDept(Department department);
}
