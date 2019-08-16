import as.User;
import dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

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
    @Test
    /**
     * 测试增加
     */
    public void add()throws Exception{

        InputStream in= Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);

        SqlSession session=factory.openSession();

        IUserDao userDao=session.getMapper(IUserDao.class);

        User user=new User();
        user.setId(1249);
        user.setName("梁大夫");
        user.setObject("眼科");
        user.setPassword("456");

        userDao.addUser(user);
        session.commit();

        session.close();
        in.close();
    }
    @Test
    /**
     * 测试删除
     */
    public void delete()throws Exception{

        InputStream in= Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);

        SqlSession session=factory.openSession();

        IUserDao userDao=session.getMapper(IUserDao.class);


        userDao.deleteUser(1249);
        session.commit();

        session.close();
        in.close();
    }
    @Test
    /**
     * 测试修改
     */
    public void update()throws Exception{

        InputStream in= Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);

        SqlSession session=factory.openSession();

        IUserDao userDao=session.getMapper(IUserDao.class);


        User user=new User();
        user.setId(1245);
        user.setName("梁大夫");
        user.setObject("眼科");
        user.setPassword("456");
        userDao.updateUser(user);
        session.commit();

        session.close();
        in.close();
    }
    @Test
    /**
     * 测试查找一个
     */
    public void findById()throws Exception{

        InputStream in= Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);

        SqlSession session=factory.openSession();

        IUserDao userDao=session.getMapper(IUserDao.class);
        User user=userDao.findById(1245);
        System.out.println(user);

        session.commit();

        session.close();
        in.close();
    }
}
