package dao;

import java.util.List;
import as.User;

/**
 * @author zzzz
 * @create 2019-08-15 上午10:50
 */
public interface IUserDao {
    /**
     * 查询所有
     * @return
     */
    List<User> findAll();
}
