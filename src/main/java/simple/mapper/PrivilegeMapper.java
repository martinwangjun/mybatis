package simple.mapper;

import org.apache.ibatis.annotations.SelectProvider;

import simple.pojo.SysPrivilege;
import simple.provider.PrivilegeProvider;

public interface PrivilegeMapper {
    @SelectProvider(type = PrivilegeProvider.class, method = "selectById")
    SysPrivilege selectById(Long id);
}
