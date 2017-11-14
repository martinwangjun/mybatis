package simple.mapper;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import junit.framework.TestCase;
import simple.pojo.SysRole;

public class RoleMapperTest extends BaseMapperTest{
    // @Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = roleMapper.selectById(1L);
            TestCase.assertNotNull(role);
        } finally {
            sqlSession.close();
        }
    }
    
    // @Test
    public void testSelectById2() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = 
                    sqlSession.getMapper(RoleMapper.class);
            SysRole role = roleMapper.selectById2(1L);
            TestCase.assertNotNull(role);
        } finally {
            sqlSession.close();
        }
    }
    
    // @Test
    public void testInsert() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = new SysRole();
            role.setRoleName("观察员1");
            role.setCreateBy(1L);
            role.setEnabled(1);
            role.setCreateTime(new Date());
            int qty = roleMapper.insert(role);
            System.out.println("Qty = " + qty);
            TestCase.assertEquals(1, qty);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    // @see https://www.cnblogs.com/nuccch/p/7093843.html
    // @Test
    public void testInsert2() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = new SysRole();
            role.setRoleName("观察员2");
            role.setCreateBy(1L);
            role.setEnabled(1);
            role.setCreateTime(new Date());
            int qty = roleMapper.insert2(role);
            //  id 只是更新的记录数，需要用role.getId()才能得到自增的数量
            System.out.println("Qty = " + qty);
            System.out.println("Id = " + role.getId());
            TestCase.assertTrue(role.getId() > 0);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    // @see https://www.cnblogs.com/weidiao/p/6835301.html
    // 没有成功
    // @Test
    public void testInsert3() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = new SysRole();
            role.setRoleName("观察员3");
            role.setCreateBy(1L);
            role.setEnabled(1);
            role.setCreateTime(new Date());
            int qty = roleMapper.insert3(role);
            System.out.println("Qty = " + qty);
            System.out.println(role.getId());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    // @Test
    public void testUpdate() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = new SysRole();
            role.setId(1);
            role.setRoleName("观察员3");
            role.setCreateBy(1L);
            role.setEnabled(1);
            role.setCreateTime(new Date());
            roleMapper.updateById(role);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
    @Test
    public void testDelete() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            roleMapper.deleteById(1L);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    
}
