package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pojo.Role;

public class JdbcExample {
    private final static Log logger = LogFactory.getLog(JdbcExample.class);
    
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=UTF-8&jdbcCompliantTruncation=false&zeroDateTimeBehavior=convertToNull";
    private final String user = "root";
    private final String password = "";
    
    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return connection;
    }
    
    public Role getRole(Long id) {
        Connection connection = getConnection();
        Role role = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id, role_name, note FROM t_role WHERE id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String userName = rs.getString("role_name");
                String note = rs.getString("note");
                role = new Role();
                role.setId(id);
                role.setRoleName(userName);
                role.setNote(note);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            try {
                if(rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if(ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if(connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        
        
        return role;
    }
    
    public static void main(String[] args) {
        JdbcExample example = new JdbcExample();
        Role role = example.getRole(2L);
        System.out.println(role.getRoleName());
    }
    
}
