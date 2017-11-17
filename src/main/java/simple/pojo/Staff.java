package simple.pojo;

import java.io.Serializable;

public class Staff implements Serializable{
    private static final long serialVersionUID = -1519403863154069028L;

    private Long staffId;
    private String name;
    private Integer power;
    private Integer leadership;
    private Integer wisdom;
    private Integer policy;
    private Integer isDead;
    public Long getStaffId() {
        return staffId;
    }
    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPower() {
        return power;
    }
    public void setPower(Integer power) {
        this.power = power;
    }
    public Integer getLeadership() {
        return leadership;
    }
    public void setLeadership(Integer leadership) {
        this.leadership = leadership;
    }
    public Integer getWisdom() {
        return wisdom;
    }
    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }
    public Integer getPolicy() {
        return policy;
    }
    public void setPolicy(Integer policy) {
        this.policy = policy;
    }
    public Integer getIsDead() {
        return isDead;
    }
    public void setIsDead(Integer isDead) {
        this.isDead = isDead;
    }
}
