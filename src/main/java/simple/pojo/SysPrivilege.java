package simple.pojo;

import java.io.Serializable;

/**
 * 
 * id
privilege_name
privilege_url
 * @author martin.wang
 *
 */
public class SysPrivilege implements Serializable{
    private static final long serialVersionUID = 6682870668014988531L;
    private Long id;
    private String privilegeName;
    private String privilegeUrl;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPrivilegeName() {
        return privilegeName;
    }
    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }
    public String getPrivilegeUrl() {
        return privilegeUrl;
    }
    public void setPrivilegeUrl(String privilegeUrl) {
        this.privilegeUrl = privilegeUrl;
    }
}
