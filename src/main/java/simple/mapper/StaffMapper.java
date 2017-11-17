package simple.mapper;

import java.util.List;

import simple.pojo.Staff;

public interface StaffMapper {
    Staff selectById(Long id);
    List<Staff> selectAll();
    List<Staff> selectByName(String name);
    Integer insert(Staff staff);
}
