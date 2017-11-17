package simple.mapper;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;
import simple.pojo.Staff;

public class StaffMapperTest {
    private static SqlSessionFactory sqlSessionFactory;
    
    @BeforeClass
    public static void init() {
        try {
            Reader config = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
            config.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
    
    @Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlSession();
        try {
            StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);
            Staff staff = staffMapper.selectById(1L);
            System.out.println(staff.getName());
        } finally {
            sqlSession.close();
        }
    }
    
    //@Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlSession();
        try {
            StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);
            List<Staff> staffList = staffMapper.selectAll();
            TestCase.assertNotNull(staffList);;
        } catch (Exception e) {
            sqlSession.close();
        }
    }
    
    // @Test
    public void testSelectByName() {
        SqlSession sqlSession = getSqlSession();
        try {
            StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);
            List<Staff> staffList = staffMapper.selectByName("张");
            TestCase.assertNotNull(staffList);
        } finally {
            sqlSession.close();
        }
    }
    
    // @Test
    public void testInsert() {
        SqlSession sqlSession = getSqlSession();
        try {
            StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);
            Staff staff = new Staff();
            staff.setName("张燕");
            staff.setPolicy(42);
            staff.setWisdom(45);
            staff.setPower(82);
            staff.setLeadership(75);
            int qty = staffMapper.insert(staff);
            System.out.println(qty);
            TestCase.assertTrue(staff.getStaffId() > 1);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
