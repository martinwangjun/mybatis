package simple.pojo;

import java.io.Serializable;

public class SysUserRole implements Serializable{
    private static final long serialVersionUID = 7829246774162429860L;
    private Integer id;
    private Long userId;
    private Long roleId;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
