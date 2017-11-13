package simple.mapper;

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
            SysRole role = userMapper.selectRolesByUserId(1001L);
            TestCase.assertNotNull(role);
            TestCase.assertEquals("普通用户", role.getRoleName());
        } finally {
            sqlSession.close();
        }
    }
}
