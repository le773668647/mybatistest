import as.User;
import dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zzzz
 * @create 2019-08-15 下午4:05
 */
public class Mybatistest {
    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream in= Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        //生产SqlSession对象
        SqlSession session=factory.openSession();
        //使用SqlSession创建dao接口的代理对象
        IUserDao userDao=session.getMapper(IUserDao.class);
        //使用代理对象执行方法
        List<User> userList=userDao.findAll();
        for (User user:userList){
            System.out.println(user.toString());

        }

        session.close();
        in.close();

    }
}
