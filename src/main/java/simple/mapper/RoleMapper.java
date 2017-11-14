package simple.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import simple.pojo.SysRole;

public interface RoleMapper {
    // 使用注解方式来配置Mapper
    @Select({"SELECT id, role_name AS roleName, enabled, "
            + "create_by AS createBy, create_time AS createTime "
            + "FROM sys_role "
            + "WHERE id = #{id}"})
    SysRole selectById(Long id);
    
    // 使用注解来配置Mapper，不设置sql里字段的别名
    @Results({
        @Result(property="id", column="id", id=true),
        @Result(property="roleName", column="role_name", id=true),
        @Result(property="enabled", column="enabled"),
        @Result(property="createBy", column="create_by"),
        @Result(property="createTime", column="create_time")
    })
    @Select({"SELECT id, role_name, enabled, create_by, create_time "
            + "FROM sys_role WHERE id = #{id}"})
    SysRole selectById2(Long id);
    
    // @Insert注解，不需要返回主键
    @Insert({"INSERT INTO sys_role(id, role_name, enabled, create_by, create_time) "
            + "VALUES(#{id}, #{roleName}, #{enabled}, #{createBy}, "
            + "#{createTime, jdbcType=TIMESTAMP})"})
    int insert(SysRole sysRole);
    
    // 返回自增主键
    @Insert({"INSERT INTO sys_role(role_name, enabled, create_by, create_time) "
            + "VALUES(#{roleName}, #{enabled}, #{createBy}, "
            + "#{createTime, jdbcType=TIMESTAMP})"})
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn="id")
    int insert2(SysRole sysRole);
    
    // TODO 这个没有成功
    // 返回非自增主键
    @Insert({"INSERT INTO sys_role(role_name, enabled, create_by, create_time) "
            + "VALUES(#{role.roleName}, #{role.enabled}, #{role.createBy}, "
            + "#{role.createTime, jdbcType=TIMESTAMP})"})
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", 
        keyProperty = "id", 
        resultType = Integer.class, 
        before = false)
    int insert3(@Param("role")SysRole role);
    
    
    @Update({"UPDATE sys_role SET role_name = #{role.roleName}, enabled = #{role.enabled}, "
            + "create_by = #{role.createBy}, "
            + "create_time = #{role.createTime, jdbcType=TIMESTAMP} "
            + "WHERE id = #{role.id}"})
    int updateById(@Param("role")SysRole role);
    
    @Delete("DELETE FROM sys_role WHERE id = #{id}")
    int deleteById(Long id);
}
