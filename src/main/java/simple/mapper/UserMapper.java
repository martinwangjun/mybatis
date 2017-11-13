package simple.mapper;

import java.util.List;

import simple.pojo.SysRole;
import simple.pojo.SysUser;

public interface UserMapper{
    SysUser selectById(Long id);
    List<SysUser> selectAll();
    SysRole selectRolesByUserId(Long id);
}
