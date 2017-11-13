package simple.pojo;

import java.io.Serializable;

public class SysRolePrivilege implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Long roleId;
    private Long privilegeId;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getPrivilegeId() {
        return privilegeId;
    }
    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
