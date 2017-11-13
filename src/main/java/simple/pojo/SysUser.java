package simple.pojo;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable{
    // 在实体类中，不要使用基本数据类型，原因如下：
    // 基本数据类型会有默认值，有的时候会造成迷之问题：
    // 如： int age; 
    // age就算不赋值，默认值就是0，无法实现age = null的效果
    private static final long serialVersionUID = -7330431841815434229L;
    private Long id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userInfo;
    private byte[] headImg;
    private Date createTime;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserInfo() {
        return userInfo;
    }
    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }
    public byte[] getHeadImg() {
        return headImg;
    }
    public void setHeadImg(byte[] headImg) {
        this.headImg = headImg;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
