package simple.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import simple.mapper.UserMapper;
import simple.pojo.SysUser;

@Controller
@RequestMapping(value="/user")
public class IndexController {
    private ApplicationContext applicationContext;
    
    
    @RequestMapping(value="/hello")
    public String aa(Model model) {
        model.addAttribute("message", "Test @ " + new Date());
        return "aa";
    }
    
    @RequestMapping(value="/detail")
    public String detail(Model model) {
        List<String> users = new ArrayList<>();
        
        applicationContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        //调用userMapper的方法
        List<SysUser> userList = userMapper.selectAll();

        for(SysUser sysUser: userList) {
            users.add(sysUser.getUserName());
        }

        model.addAttribute("users", users);
        return "detail";
    }
    
    @RequestMapping(value="/detail/{id}")
    public String detail(
            @PathVariable("id") String id,
            Model model) {
        Long userId = 1L;
        try {
            userId = Long.parseLong(id);
        }
        catch (Exception e) {
            return "no_user_existing";
        }
        
        List<String> users = new ArrayList<>();
        
        applicationContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        //调用userMapper的方法
        SysUser user = userMapper.selectById(userId);
        
        if(user != null) {
            users.add(user.getUserName());
        }
        
        
        model.addAttribute("users", users);
        return "detail";
    }
}
