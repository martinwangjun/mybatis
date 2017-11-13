package simple.mapper;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

public class BaseMapperTest {
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
    
    public SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}




