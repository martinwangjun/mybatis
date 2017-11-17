package simple.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import junit.framework.TestCase;
import simple.pojo.SysRole;
import simple.pojo.SysUser;

public class UserMapperTest extends BaseMapperTest{

    // @Test
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
    
    // @Test
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
     
    // @Test
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
    
    // @Test
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
    
    // @Test
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
    
    // @Test
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
    
    // @Test
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
    
    // @Test
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
    
    // @Test
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
    
    // @Test
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
    
    // @Test
    public void testSelectByUser() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser query = new SysUser();
            
            // 只查询用户名
            query.setUserName("ad");
            List<SysUser> userList = userMapper.selectByUser(query);
            userList.forEach(obj->System.out.println(obj));
            
            System.out.println("------------------");
            
            // 只查询电子邮件
            query = new SysUser();
            query.setUserEmail("ada@test.com");
            userList = userMapper.selectByUser(query);
            userList.forEach(o->System.out.println(o));
            
            System.out.println("------------------");
            
            // 当同时查询用户名和邮件
            query = new SysUser();
            query.setUserEmail("ada@test.com");
            query.setUserName("ad");
            userList = userMapper.selectByUser(query);
            userList.forEach(o->System.out.println(o));
            
        } finally {
            sqlSession.close();
        }
    }
    
    // @Test
    public void testUpdateByIdSelective() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setId(1L);
            user.setUserEmail("admin@test.com");
            int qty = userMapper.updateByIdSelective(user);
            TestCase.assertEquals(qty, 1);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    // @Test
    public void testInsert4() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("Sam");
            user.setHeadImg(new byte[] {1, 2, 3});
            user.setCreateTime(new Date());
            user.setUserPassword("123456");
            user.setUserInfo("测试信息");
            int qty = userMapper.insert4(user);
            TestCase.assertEquals(qty, 1);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    // @Test
    public void testSelectByIdOrUserName() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser query = new SysUser();
            query.setId(1005L);
            List<SysUser> userList = userMapper.selectByIdOrUserName(query);
            userList.forEach(obj->System.out.println(obj));
            TestCase.assertTrue(userList.size() > 0);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    // @Test
    public void testSelectByUser2() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser query = new SysUser();
            query.setUserInfo("test");
            List<SysUser> userList = userMapper.selectByUser2(query);
            TestCase.assertTrue(userList.size() > 1);
        } finally {
            sqlSession.close();
        }
    }
    
    // @Test
    public void testUpdateByIdSelective2() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setId(1002L);
            user.setUserInfo("A quick brown fox jumps over a lazy dog.");
            int qty = userMapper.updateByIdSelective2(user);
            TestCase.assertEquals(1, qty);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    // @Test
    public void testSelectByIdList1() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<Long> ids = new ArrayList<>();
            ids.add(1003L);
            ids.add(1005L);
            List<SysUser> userList = userMapper.selectByIdList1(ids);
            userList.forEach(obj->System.out.println(obj));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    // @Test
    public void testSelectByIdList2() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Long[] idArray = {1003L, 1008L};
            List<SysUser> userList = userMapper.selectByIdList2(idArray);
            userList.forEach(obj->System.out.println(obj));
        } finally {
            sqlSession.close();
        }
    }
    
    // @Test
    public void testSelectByIdList3() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<Long> ids = new ArrayList<>();
            ids.add(1003L);
            ids.add(1009L);
            Map<String, Object> params = new HashMap<>();
            params.put("ids", ids);
            params.put("title", "Haha");
            List<SysUser> userList = userMapper.selectByIdList3(params);
            userList.forEach(obj->System.out.println(obj));
        } finally {
            sqlSession.close();
        }
    }
    
    // @Test
    public void testInsertList() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> userList = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                SysUser user = new SysUser();
                user.setUserName("Linda" + i);
                user.setUserPassword("123456");
                user.setUserEmail("linda" + i + "@test.com");
                userList.add(user);
            }
            int result = userMapper.insertList(userList);
            System.out.println(result);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    // @Test
    public void testUpdateByMap(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("id", 1L);
            map.put("user_email", "admin1@test.com");
            map.put("user_password", "654321");
            userMapper.updateByMap(map);
            SysUser user = userMapper.selectById(1L);
            System.out.println(user);
            TestCase.assertEquals("654321", user.getUserPassword());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    @Test
    public void testSelectByUserName() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser query = new SysUser();
            query.setUserName("ad");
            List<SysUser> userList = userMapper.selectByUserName(query);
            userList.forEach(obj->System.out.println(obj));
        } finally {
            sqlSession.close();
        }
    }
    
}
