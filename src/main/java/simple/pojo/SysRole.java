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
    private Long createdBy;
    private Date createdTime;
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
    public Long getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
    public Date getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
