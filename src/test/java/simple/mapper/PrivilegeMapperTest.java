package simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import junit.framework.TestCase;
import simple.pojo.SysPrivilege;

public class PrivilegeMapperTest extends BaseMapperTest{
    @Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlSession();
        try {
            PrivilegeMapper privilegeMapper = 
                    sqlSession.getMapper(PrivilegeMapper.class);
            SysPrivilege privilege = privilegeMapper.selectById(1L);
            TestCase.assertNotNull(privilege);
            System.out.println(privilege.getPrivilegeName());
            TestCase.assertEquals("用户管理", privilege.getPrivilegeName());
        } finally {
            sqlSession.close();
        }
    }
}
