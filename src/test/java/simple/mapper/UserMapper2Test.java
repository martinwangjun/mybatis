package simple.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import simple.pojo.SysUser;

public class UserMapper2Test {
    private ApplicationContext applicationContext;
    
    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");
    }
    
    @Test
    public void testFindUserById() throws Exception {
        UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        //调用userMapper的方法
        SysUser user = userMapper.selectById(1L);
        System.out.println(user);

    }
}
