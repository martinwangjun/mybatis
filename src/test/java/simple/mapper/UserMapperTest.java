package simple.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import junit.framework.TestCase;
import simple.pojo.SysRole;
import simple.pojo.SysUser;

public class UserMapperTest extends BaseMapperTest{

    @Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1L);
            TestCase.assertNotNull(user);
            TestCase.assertEquals("admin", user.getUserName());
        } finally {
            sqlSession.close();
        }
    }
    
    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> userList = userMapper.selectAll();
            TestCase.assertNotNull(userList);
            TestCase.assertTrue(userList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }
     
    @Test
    public void testSelectRolesByUserId() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> roleList = userMapper.selectRolesByUserId(1001L);
            TestCase.assertNotNull(roleList);
            TestCase.assertTrue(roleList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }
    
    @Test
    public void testInsert() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("宋江");
            user.setUserPassword("Password1");
            user.setUserEmail("jiang.song@test.com");
            user.setUserInfo("TEST INFO");
            user.setHeadImg(new byte[] {1, 2, 3});
            user.setCreateTime(new Date());
            int result = userMapper.insert(user);
            TestCase.assertEquals(1, result);
            TestCase.assertNull(user.getId());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    @Test
    public void testInsert2() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("林冲");
            user.setUserPassword("Password1");
            user.setUserEmail("chong.lin@test.com");
            user.setUserInfo("TEST INFO");
            user.setHeadImg(new byte[] {1, 2, 3});
            user.setCreateTime(new Date());
            int result = userMapper.insert2(user);
            TestCase.assertEquals(1, result);
            TestCase.assertNotNull(user.getId());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    @Test
    public void testInsert3() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("武松");
            user.setUserPassword("Password1");
            user.setUserEmail("song.wu@test.com");
            user.setUserInfo("TEST INFO");
            user.setHeadImg(new byte[] {1, 2, 3});
            user.setCreateTime(new Date());
            int result = userMapper.insert3(user);
            TestCase.assertEquals(1, result);
            TestCase.assertNotNull(user.getId());
            System.out.println("User Id" + user.getId());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    @Test
    public void testUpdateById(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1L);
            user.setUserInfo("This is a test.");
            int result = userMapper.updateById(user);
            TestCase.assertEquals(1, result);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    @Test
    public void testDeleteById() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user1 = userMapper.selectById(1L);
            TestCase.assertNotNull(user1);
            TestCase.assertEquals(1, userMapper.deleteById(1L));
            TestCase.assertNull(userMapper.selectById(1L));
            
            SysUser user2 = userMapper.selectById(1001L);
            TestCase.assertNotNull(user2);
            TestCase.assertEquals(1, userMapper.deleteById(user2));
            TestCase.assertNull(userMapper.selectById(1001L));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    @Test
    public void testSelectRolesByUserIdAndRoleEnabled() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = 
                    sqlSession.getMapper(UserMapper.class);
            List<SysRole> roleList = 
                    userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
            TestCase.assertNotNull(roleList);
            TestCase.assertTrue(roleList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }
    
    @Test
    public void testSelectRolesByUserAndRole() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = 
                    sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1L);
            SysRole role = new SysRole();
            role.setEnabled(1);
            
            List<SysRole> roleList = 
                    userMapper.selectRolesByUserAndRole(user, role);
            TestCase.assertNotNull(roleList);
            TestCase.assertTrue(roleList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }
}
