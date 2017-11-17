package simple.mapper;

import java.util.List;
import java.util.Map;

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

    List<SysUser> selectByUser(SysUser user);
    
    int updateByIdSelective(SysUser user);
    
    int insert4(SysUser user);
    
    List<SysUser> selectByIdOrUserName(SysUser user);
    List<SysUser> selectByUser2(SysUser user);
    
    int updateByIdSelective2(SysUser user);
    
    // foreach
    List<SysUser> selectByIdList1(List<Long> idList);
    List<SysUser> selectByIdList2(Long[] idArray);
    List<SysUser> selectByIdList3(Map<String, Object> map);
    
    int insertList(List<SysUser> userList);
    
    int updateByMap(Map<String, Object>map);
    
    List<SysUser> selectByUserName(SysUser user);
}
