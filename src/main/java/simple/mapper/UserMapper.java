package simple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import simple.pojo.SysRole;
import simple.pojo.SysUser;

public interface UserMapper{
    SysUser selectById(Long id);
    List<SysUser> selectAll();
    List<SysRole> selectRolesByUserId(Long id);
    int insert(SysUser user);
    int insert2(SysUser user);
    int insert3(SysUser user);
    int updateById(SysUser user);
    int deleteById(Long id);
    int deleteById(SysUser user);
    
    List<SysRole> selectRolesByUserIdAndRoleEnabled(
            @Param("userId")Long userId, 
            @Param("enabled")Integer enabled);
    List<SysRole> selectRolesByUserAndRole(
            @Param("user") SysUser user,
            @Param("role") SysRole role
            );
}
