package simple.pojo;

import java.io.Serializable;
import java.sql.Date;

/**
 * 
 * @author martin.wang
 *
 */
public class SysRole implements Serializable{
    private static final long serialVersionUID = -569747311759040223L;
    private Integer id;
    private String roleName;
    private Integer enabled;
    private Long createBy;
    private Date createTime;
    private SysUser user;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public Integer getEnabled() {
        return enabled;
    }
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
    public Long getCreateBy() {
        return createBy;
    }
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public SysUser getUser() {
        return user;
    }
    public void setUser(SysUser user) {
        this.user = user;
    }
}
